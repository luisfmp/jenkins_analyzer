package org.treadstone.jenkins.analyzer.pages;

import org.openqa.selenium.WebDriver;
import org.treadstone.jenkins.analyzer.Projects;

public class PageFactory2 {

    public static JenkinsReportPage redirectToReportPage(WebDriver driver, Projects project, String testType) {
        driver.get("http://wdpr-cast-platform.cloud.corp.dig.com/jenkins/job/cast-platform-apps."
                + project.getJenkinsName()
                + "/job/" + testType + "/lastCompletedBuild/testReport/");
        return new JenkinsReportPage(driver);
    }

    public static GitHubPage redirectToGitHubPage(WebDriver driver, Projects project) {
        driver.get("https://github.disney.com/cast-platform-apps/" + project.getGithubName() + "/find/automation");
        return new GitHubPage(driver);
    }

}
