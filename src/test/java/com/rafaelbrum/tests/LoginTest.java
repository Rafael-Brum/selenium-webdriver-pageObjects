package com.rafaelbrum.tests;

import com.rafaelbrum.pages.InventoryPage;
import com.rafaelbrum.utils.TestDataLoader;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    @Description("Deve autenticar com credenciais validas e abrir o catalogo")
    void shouldLoginSuccessfully() {
        String validUser = TestDataLoader.get("users.validUser");
        String validPassword = TestDataLoader.get("passwords.validPassword");

        InventoryPage inventoryPage = loginPage.loginWithValidUser(validUser, validPassword);
        String pageTitle = inventoryPage.getTitle();

        Assertions.assertEquals("Products", pageTitle,
                "Titulo esperado apos login valido deve ser 'Products'.");
    }

    @Test
    @Description("Deve exibir erro para usuario invalido")
    void shouldShowErrorForInvalidCredentials() {
        String invalidUser = TestDataLoader.get("users.invalidUser");
        String invalidPassword = TestDataLoader.get("passwords.invalidPassword");
        String expectedError = TestDataLoader.get("expectedMessages.invalidCredentials");

        loginPage.loginExpectingFailure(invalidUser, invalidPassword);
        String actualError = loginPage.getErrorMessage();

        Assertions.assertEquals(expectedError, actualError,
                "Mensagem de erro para credenciais invalidas nao corresponde ao esperado.");
    }

    @Test
    @Description("Deve bloquear login de usuario locked")
    void shouldShowErrorForLockedUser() {
        String lockedUser = TestDataLoader.get("users.lockedUser");
        String validPassword = TestDataLoader.get("passwords.validPassword");
        String expectedError = TestDataLoader.get("expectedMessages.lockedUser");

        loginPage.loginExpectingFailure(lockedUser, validPassword);
        String actualError = loginPage.getErrorMessage();

        Assertions.assertEquals(expectedError, actualError,
                "Mensagem de bloqueio de usuario nao corresponde ao esperado.");
    }
}
