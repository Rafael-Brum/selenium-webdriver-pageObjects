package com.rafaelbrum.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public final class TestDataLoader {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final JsonNode ROOT;

    static {
        try (InputStream input = TestDataLoader.class.getClassLoader().getResourceAsStream("data/test_data.json")) {
            if (input == null) {
                throw new IllegalStateException("Arquivo data/test_data.json nao encontrado no classpath.");
            }
            ROOT = MAPPER.readTree(input);
        } catch (IOException ex) {
            throw new IllegalStateException("Falha ao ler data/test_data.json", ex);
        }
    }

    private TestDataLoader() {
    }

    public static String get(String path) {
        JsonNode current = ROOT;
        for (String key : path.split("\\.")) {
            current = current.path(key);
        }
        if (current.isMissingNode() || current.isNull()) {
            throw new IllegalArgumentException("Caminho de dados invalido: " + path);
        }
        return current.asText();
    }
}
