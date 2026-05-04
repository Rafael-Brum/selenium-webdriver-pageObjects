package com.rafaelbrum.pages;

import com.rafaelbrum.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WaitUtils wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    protected void click(By locator) {
        wait.clickable(locator).click();
    }

    protected void type(By locator, String value) {
        wait.visible(locator).clear();
        wait.visible(locator).sendKeys(value);
    }

    protected String text(By locator) {
        return wait.visible(locator).getText();
    }
}
