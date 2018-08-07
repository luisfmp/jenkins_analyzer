package org.treadstone.jenkins.analyzer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubPage extends AbstractPage {

    @FindBy(id = "tree-finder-field")
    private WebElement search;

    GitHubPage(WebDriver driver) {
        super(driver);
        // System.out.print("Page loaded: " + driver.getCurrentUrl());
    }

    public GitHubPage searchClass(String className) {
        search.click();
        search.sendKeys(className);
        return this;
    }

    public GitHubClassPage clickLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//*[@id=\"tree-finder-results\"]/tbody[2]/tr[1]/td[3]/a")));
        driver
                .findElement(By.xpath(
                        "//*[@id=\"tree-finder-results\"]/tbody[2]/tr[1]/td[3]/a"))
                .click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GitHubClassPage(driver);
    }

}
