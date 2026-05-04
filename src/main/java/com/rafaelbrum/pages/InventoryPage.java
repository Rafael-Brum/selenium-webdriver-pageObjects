package com.rafaelbrum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {
    private final By inventoryTitle = By.cssSelector("span[data-test='title']");
    private final By cartLink = By.cssSelector("a[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("span[data-test='shopping-cart-badge']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return text(inventoryTitle);
    }

    public InventoryPage addProductToCartById(String productId) {
        By addButton = By.id("add-to-cart-" + productId);
        WebElement element = wait.visible(addButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        try {
            element.click();
        } catch (WebDriverException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
        return this;
    }

    public String getCartBadgeCount() {
        return text(cartBadge);
    }

    public CartPage openCart() {
        click(cartLink);
        return new CartPage(driver);
    }
}
