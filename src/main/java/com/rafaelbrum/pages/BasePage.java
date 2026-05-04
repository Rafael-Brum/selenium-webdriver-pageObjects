package com.rafaelbrum.pages;

import com.rafaelbrum.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        WebElement element = wait.visible(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected String text(By locator) {
        return wait.visible(locator).getText();
    }
}
