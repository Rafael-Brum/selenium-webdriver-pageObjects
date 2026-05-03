package com.rafaelbrum.config;

import io.github.cdimascio.dotenv.Dotenv;

public final class EnvConfig {
    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();

    private EnvConfig() {
    }

    public static String baseUrl() {
        return DOTENV.get("BASE_URL", "https://www.saucedemo.com/");
    }

    public static String username() {
        return DOTENV.get("SAUCE_USERNAME", "standard_user");
    }

    public static String password() {
        return DOTENV.get("SAUCE_PASSWORD", "secret_sauce");
    }

    public static String browser() {
        return DOTENV.get("BROWSER", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(DOTENV.get("HEADLESS", "false"));
    }

    public static int timeoutSeconds() {
        return Integer.parseInt(DOTENV.get("TIMEOUT_SECONDS", "10"));
    }
}
