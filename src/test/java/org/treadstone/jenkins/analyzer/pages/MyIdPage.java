package org.treadstone.jenkins.analyzer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyIdPage extends AbstractPage {

    @FindBy(id = "inputEmail")
    private WebElement email;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "submitButton")
    private WebElement signIn;

    public MyIdPage(WebDriver driver) {
        super(driver);
    }

    public JenkinsWelcomePage logIn(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signIn.click();
        return new JenkinsWelcomePage(driver);
    }

}
