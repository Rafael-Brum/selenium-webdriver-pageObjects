package com.rafaelbrum.tests;

import com.rafaelbrum.config.EnvConfig;
import com.rafaelbrum.pages.LoginPage;
import com.rafaelbrum.utils.DriverFactory;
import com.rafaelbrum.utils.ScreenshotUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver).open(EnvConfig.baseUrl());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        if (driver != null) {
            ScreenshotUtils.attachScreenshot(driver, "evidence-" + testInfo.getDisplayName());
            driver.quit();
        }
    }
}
