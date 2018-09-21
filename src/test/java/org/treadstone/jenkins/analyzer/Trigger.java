package org.treadstone.jenkins.analyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.treadstone.jenkins.analyzer.pages.GitHubPage;
import org.treadstone.jenkins.analyzer.pages.JenkinsReportPage;
import org.treadstone.jenkins.analyzer.pages.MyIdPage;
import org.treadstone.jenkins.analyzer.pages.PageFactory2;
import org.treadstone.jenkins.analyzer.utils.FilesUtil;
import org.treadstone.jenkins.analyzer.utils.Util;

/**
 * Created by jose.oropeza on 12/27/2017.
 */
public class Trigger {

    private static ChromeDriverService service;
    private WebDriver driver;
    private List<Failure> failures = new ArrayList<Failure>();

    @Before
    public void before() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\temp\\chromedriver\\win32\\2.38\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
        createDriver();
    }

    private void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
    }

    @Test
    public void run() throws IOException {
        driver.get("http://wdpr-cast-platform.cloud.corp.dig.com/jenkins/view/cast-platform-apps/");
        MyIdPage myIdPage = new MyIdPage(driver);
        myIdPage.logIn("MARTL372", "BokuNoHero84");
        for (Projects project : Projects.values()) {
            for (String testType : project.getTypesSupported()) {
                JenkinsReportPage reportPage = PageFactory2.redirectToReportPage(driver, project,
                        testType);
                if (reportPage.hasFailures()) {
                    List<String> failedClasses = reportPage.getFailedClasses();
                    for (String failedClass : failedClasses) {
                        failures.add(new Failure(null, testType, failedClass, project, null));
                    }
                }
            }
        }
        System.out.println("Failures found: " + failures.size());
        for (Failure failure : failures) {
            GitHubPage githubPage = PageFactory2.redirectToGitHubPage(driver, failure.getProject());
            String authorFound = "";
            try {
                authorFound = githubPage.searchClass(failure.getName()).clickLink().getAuthor();
            } catch (Exception exception) {
                // Do nothing.
            }
            failure.setAuthor(Util.getAuthor(authorFound));
            failure.setAlias(authorFound);
        }
        createFile();
    }

    private void createFile() throws IOException {
        System.out.println("Creating the file...");
        String input = "";
        for (Users user : Users.values()) {
            input += user.getSlack() + ":\n";
            for (Failure failure : failures) {
                if (user.equals(failure.getAuthor())) {
                    input += failure.getProject() + " - " + failure.getGroup() + " - "
                            + failure.getName() + " - "
                            + failure.getAlias().replace(" * ", "") + "\n";
                }
            }
            input += "\n";
        }
        // input += "Bugs:\n";
        for (Failure failure : failures) {
            if (failure.getAuthor() == null) {
                input += failure.getProject() + " - " + failure.getGroup() + " - " + failure.getName() + " - " +
                        failure.getAlias().replace(" * ", "") + "\n";
            }
        }
        input += "\n";

        FilesUtil.writeToTextFile("target/output.txt", input);
    }

    @After
    public void after() {
        service.stop();
    }
}
