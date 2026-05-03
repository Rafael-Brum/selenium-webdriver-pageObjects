# Arquitetura e Padrões

## Stack
- Java 17
- Selenium WebDriver 4
- JUnit 5
- Allure Report
- WebDriverManager

## Padrões aplicados
- Page Object Model com uma classe por tela
- Test Data Management via JSON
- Configuração sensível via `.env`
- Wait explícito via `WebDriverWait`
- Evidências via screenshot anexado no Allure

## Princípios de qualidade
- Testes independentes e idempotentes
- Assertions descritivas
- Sem hardcode de massa de dados em testes
