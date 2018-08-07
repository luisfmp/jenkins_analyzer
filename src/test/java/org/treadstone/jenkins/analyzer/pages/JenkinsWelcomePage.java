package org.treadstone.jenkins.analyzer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsWelcomePage extends AbstractPage {

    @FindBy(id = "jenkins-name-icon")
    private WebElement logo;

    public JenkinsWelcomePage(WebDriver driver) {
        super(driver);
    }

    public JenkinsWelcomePage getProjectPage() {
        return null;
    }

}
