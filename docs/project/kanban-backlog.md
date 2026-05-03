# Backlog e Kanban (base para GitHub Projects)

## Colunas sugeridas
- To Do
- In Progress
- Done

## Issues sugeridas
1. Mapeamento de páginas e elementos do SauceDemo
- Labels: `feature`, `test`, `documentation`
- Critérios de aceitação:
  - Fluxo login -> catalogo -> carrinho -> checkout mapeado
  - Seletores principais documentados
  - Documento versionado no repositório

2. Criar Page Object de LoginPage
- Labels: `feature`, `test`
- Critérios de aceitação:
  - Encapsular campos e ações de login
  - Expor operações de login válido e inválido

3. Criar Page Object de InventoryPage
- Labels: `feature`, `test`
- Critérios de aceitação:
  - Adicionar produtos ao carrinho por identificador
  - Abrir carrinho

4. Criar Page Object de CartPage
- Labels: `feature`, `test`
- Critérios de aceitação:
  - Validar presença de produto
  - Navegação para checkout

5. Criar Page Objects de Checkout
- Labels: `feature`, `test`
- Critérios de aceitação:
  - Step one preenchimento e validações
  - Step two finalização
  - Complete validação de sucesso

6. Implementar testes de login (positivo e negativo)
- Labels: `test`
- Critérios de aceitação:
  - Cobrir login válido
  - Cobrir credenciais inválidas e usuário bloqueado

7. Implementar testes de carrinho
- Labels: `test`
- Critérios de aceitação:
  - Adicionar múltiplos produtos
  - Validar contador e itens

8. Implementar testes de checkout
- Labels: `test`
- Critérios de aceitação:
  - Checkout completo de sucesso
  - Validação de erro por dados incompletos

9. Configurar Allure Report
- Labels: `feature`, `test`, `documentation`
- Critérios de aceitação:
  - Resultados gerados em `target/allure-results`
  - README com instruções de uso

10. Configurar CI/CD GitHub Actions para `development`
- Labels: `ci`, `test`
- Critérios de aceitação:
  - Trigger por push em `development`
  - Execução de testes automatizada
  - Upload de artefato Allure
