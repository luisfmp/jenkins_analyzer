package org.treadstone.jenkins.analyzer.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubClassPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'author')]/parent::span")
    private WebElement author;

    GitHubClassPage(WebDriver driver) {
        super(driver);
    }

    public String getAuthor() {
        try {
            return author.getText();
        } catch (NoSuchElementException e) {
            return "Uknown author";
        }
    }

}
