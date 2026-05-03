# Selenium WebDriver Page Objects - SauceDemo

Projeto profissional de automação de testes com **Selenium WebDriver + Java + JUnit 5 + Allure Report**, cobrindo fluxos de **login**, **carrinho** e **checkout** no [SauceDemo](https://www.saucedemo.com/).

## Arquitetura
- `src/main/java/com/rafaelbrum/pages`: Page Objects por tela/funcionalidade.
- `src/main/java/com/rafaelbrum/utils`: utilitários de driver, wait, screenshot e leitura de dados.
- `src/main/java/com/rafaelbrum/config`: configuração de ambiente (`.env`).
- `src/test/java/com/rafaelbrum/tests`: testes funcionais (positivos e negativos).
- `src/test/resources/data`: massa de dados em JSON.
- `docs/mapping`: mapeamento de páginas, elementos e fluxo.
- `.github/workflows`: pipeline CI para branch `development`.

## Pré-requisitos
- Java 17+
- Maven 3.9+
- Google Chrome instalado

## Instalação do projeto (pom.xml)
1. Clone o repositório:
```bash
git clone https://github.com/Rafael-Brum/selenium-webdriver-pageObjects.git
cd selenium-webdriver-pageObjects
```
2. Instale as dependências do `pom.xml`:
```bash
mvn clean install -DskipTests
```

## Configuração de credenciais
1. Copie `.env.example` para `.env`.
2. Edite os valores conforme necessário:
   - `SAUCE_USERNAME`
   - `SAUCE_PASSWORD`
   - `BASE_URL`
   - `BROWSER`
   - `HEADLESS`
   - `TIMEOUT_SECONDS`

> O arquivo `.env` está no `.gitignore` e não deve ser commitado.

## Execução dos testes
```bash
mvn clean test
```

## Allure Report
1. Executar testes:
```bash
mvn clean test
```
2. Gerar/visualizar relatório local:
```bash
allure serve target/allure-results
```

## Cenários cobertos
### Login
- Login com credenciais válidas.
- Login com usuário inválido.
- Login com usuário bloqueado.

### Carrinho
- Adição de dois produtos e validação de badge.
- Validação de presença dos produtos no carrinho.

### Checkout
- Checkout completo com sucesso.
- Falha de checkout por ausência de campo obrigatório.

## Independência e idempotência
- Cada teste inicializa e finaliza seu próprio WebDriver.
- Não há dependência entre métodos de teste.
- Massa de dados externa em `test_data.json`.

## Estratégia de waits
- Apenas `WebDriverWait` + `ExpectedConditions`.
- Sem `Thread.sleep`.

## Fluxo de branches
- `main`: estável
- `development`: integração e CI automático
- `RafaelBrum`: implementação individual

## CI/CD
Pipeline GitHub Actions em `.github/workflows/ci-development.yml`:
- Disparado a cada push em `development`
- Executa `mvn clean test`
- Publica artefato `allure-results`

## Organização de issues e projeto (Kanban)
Veja:
- `.github/ISSUE_TEMPLATE/*.md`
- `docs/project/kanban-backlog.md`

## Wiki
Conteúdo inicial em `wiki/` para copiar para a Wiki do GitHub:
- Mapeamento de páginas
- Arquitetura
- Guia de execução
- Aprendizados
