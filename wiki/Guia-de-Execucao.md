# Guia de Execução

## Pré-requisitos
- Java 17+
- Maven 3.9+
- Chrome

## Setup
1. Copie `.env.example` para `.env`
2. Ajuste credenciais e parâmetros

## Executar testes
```bash
mvn clean test
```

## Gerar relatório Allure
```bash
allure serve target/allure-results
```
