package com.rafaelbrum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return new CheckoutCompletePage(driver);
    }
}
