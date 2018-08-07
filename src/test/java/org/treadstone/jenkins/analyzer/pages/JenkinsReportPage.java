package org.treadstone.jenkins.analyzer.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsReportPage extends AbstractPage {

    @FindBy(css = "#main-panel > h1")
    private WebElement title;

    @FindBy(css = ".pane.sortable.bigtable.stripped")
    private WebElement failedTestsTable;

    List<String> failedTests;

    public JenkinsReportPage(WebDriver driver) {
        super(driver);
        System.out.print("Page loaded: " + driver.getCurrentUrl());
    }

    public List<String> getFailedClasses() {
        failedTests = new ArrayList<String>();
        List<WebElement> failedElements = failedTestsTable.findElements(By.cssSelector("tbody tr"));
        for (WebElement failedElement : failedElements) {
            List<WebElement> failuresLinks = failedElement.findElements(By.cssSelector(".model-link"));

            for (WebElement failure : failuresLinks) {
                if (failure.getText().startsWith("com.disney")) {
                    int endPointIndex = failure.getText().lastIndexOf(".");
                    int startPointIndex = failure.getText().substring(0, endPointIndex).lastIndexOf(".");
                    System.out.println("Adding " + failure.getText().substring(startPointIndex + 1, endPointIndex));
                    failedTests.add(failure.getText().substring(startPointIndex + 1, endPointIndex));
                }
            }
        }
        return failedTests;
    }

    public boolean hasFailures() {
        System.out.println(
                "hasFailures ? "
                        + driver.findElements(By.xpath("//h2[contains(text(),'All Failed Tests')]")).size());
        return driver.findElements(By.xpath("//h2[contains(text(),'All Failed Tests')]")).size() > 0;
    }

}
