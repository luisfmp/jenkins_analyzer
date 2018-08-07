package org.treadstone.jenkins.analyzer.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public abstract class AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoad();
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
