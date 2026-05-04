package com.rafaelbrum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutStepTwoPage extends BasePage {
    private final By finishButton = By.id("finish");
    private final By pageTitle = By.cssSelector("span[data-test='title']");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return text(pageTitle);
    }

    public CheckoutCompletePage finishCheckout() {
        click(finishButton);
        if (!driver.getCurrentUrl().contains("checkout-complete")) {
            WebElement finish = wait.clickable(finishButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", finish);
        }
        return new CheckoutCompletePage(driver);
    }
}
