package com.rafaelbrum.tests;

import com.rafaelbrum.pages.CartPage;
import com.rafaelbrum.pages.InventoryPage;
import com.rafaelbrum.utils.TestDataLoader;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    @Test
    @Description("Deve adicionar dois produtos no carrinho e validar badge")
    void shouldAddTwoProductsToCart() {
        String validUser = TestDataLoader.get("users.validUser");
        String validPassword = TestDataLoader.get("passwords.validPassword");
        String firstProduct = TestDataLoader.get("products.firstProduct");
        String secondProduct = TestDataLoader.get("products.secondProduct");

        InventoryPage inventoryPage = loginPage.loginWithValidUser(validUser, validPassword)
                .addProductToCartById(firstProduct)
                .addProductToCartById(secondProduct);

        Assertions.assertEquals("2", inventoryPage.getCartBadgeCount(),
                "Badge do carrinho deve indicar 2 itens apos adicionar dois produtos.");

        CartPage cartPage = inventoryPage.openCart();
        Assertions.assertTrue(cartPage.isProductVisibleById(firstProduct),
                "Primeiro produto esperado nao foi encontrado no carrinho.");
        Assertions.assertTrue(cartPage.isProductVisibleById(secondProduct),
                "Segundo produto esperado nao foi encontrado no carrinho.");
    }
}
