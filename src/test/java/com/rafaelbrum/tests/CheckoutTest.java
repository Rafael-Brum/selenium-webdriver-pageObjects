package com.rafaelbrum.tests;

import com.rafaelbrum.pages.CheckoutCompletePage;
import com.rafaelbrum.pages.CheckoutStepOnePage;
import com.rafaelbrum.pages.CheckoutStepTwoPage;
import com.rafaelbrum.pages.InventoryPage;
import com.rafaelbrum.utils.TestDataLoader;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends BaseTest {

    @Test
    @Description("Deve concluir checkout com sucesso")
    void shouldCompleteCheckoutSuccessfully() {
        String validUser = TestDataLoader.get("users.validUser");
        String validPassword = TestDataLoader.get("passwords.validPassword");
        String firstProduct = TestDataLoader.get("products.firstProduct");
        String secondProduct = TestDataLoader.get("products.secondProduct");

        String firstName = TestDataLoader.get("checkout.firstName");
        String lastName = TestDataLoader.get("checkout.lastName");
        String postalCode = TestDataLoader.get("checkout.postalCode");
        String expectedSuccess = TestDataLoader.get("expectedMessages.checkoutSuccess");

        InventoryPage inventoryPage = loginPage.loginWithValidUser(validUser, validPassword)
                .addProductToCartById(firstProduct)
                .addProductToCartById(secondProduct);

        CheckoutStepOnePage stepOnePage = inventoryPage.openCart().proceedToCheckout();
        CheckoutStepTwoPage stepTwoPage = stepOnePage.fillCheckoutDataAndContinue(firstName, lastName, postalCode);

        Assertions.assertEquals("Checkout: Overview", stepTwoPage.getTitle(),
                "Titulo da segunda etapa do checkout deve ser 'Checkout: Overview'.");

        CheckoutCompletePage completePage = stepTwoPage.finishCheckout();
        Assertions.assertEquals(expectedSuccess, completePage.getSuccessMessage(),
                "Mensagem final de checkout nao corresponde ao esperado.");
    }

    @Test
    @Description("Deve exibir erro ao tentar checkout com dados obrigatorios ausentes")
    void shouldShowErrorWhenCheckoutInfoIsMissing() {
        String validUser = TestDataLoader.get("users.validUser");
        String validPassword = TestDataLoader.get("passwords.validPassword");
        String firstProduct = TestDataLoader.get("products.firstProduct");
        String expectedError = TestDataLoader.get("expectedMessages.missingCheckoutInfo");

        InventoryPage inventoryPage = loginPage.loginWithValidUser(validUser, validPassword)
                .addProductToCartById(firstProduct);

        CheckoutStepOnePage stepOnePage = inventoryPage.openCart().proceedToCheckout();
        stepOnePage.continueWithMissingData("", "Brum", "90000-000");

        Assertions.assertEquals(expectedError, stepOnePage.getErrorMessage(),
                "Mensagem de validacao de campo obrigatorio do checkout nao corresponde ao esperado.");
    }
}
