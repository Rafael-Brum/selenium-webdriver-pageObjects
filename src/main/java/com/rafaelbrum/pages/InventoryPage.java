package com.rafaelbrum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        click(By.id("add-to-cart-" + productId));
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
