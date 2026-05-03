# Mapeamento de Páginas e Elementos - SauceDemo

## Fluxo executado
1. Login (`/`)
2. Catálogo (`/inventory.html`)
3. Carrinho (`/cart.html`)
4. Checkout Step One (`/checkout-step-one.html`)
5. Checkout Step Two (`/checkout-step-two.html`)
6. Checkout Complete (`/checkout-complete.html`)

## LoginPage
- Username: `#user-name`
- Password: `#password`
- Login: `#login-button`
- Erro: `h3[data-test='error']`

## InventoryPage
- Título: `span[data-test='title']`
- Add produto por id lógico: `#add-to-cart-<product-id>`
- Link carrinho: `a[data-test='shopping-cart-link']`
- Badge carrinho: `span[data-test='shopping-cart-badge']`

## CartPage
- Checkout: `#checkout`
- Validação item em carrinho: `#remove-<product-id>`

## CheckoutStepOnePage
- First Name: `#first-name`
- Last Name: `#last-name`
- Postal Code: `#postal-code`
- Continue: `#continue`
- Erro: `h3[data-test='error']`

## CheckoutStepTwoPage
- Título: `span[data-test='title']`
- Finish: `#finish`

## CheckoutCompletePage
- Mensagem de sucesso: `h2[data-test='complete-header']`

## Produtos usados no fluxo
- `sauce-labs-backpack`
- `sauce-labs-bike-light`

## Observações de modelagem
- Cada tela foi encapsulada em um Page Object dedicado.
- Testes não acessam seletores diretamente.
- Navegação entre páginas retorna o próximo Page Object para manter fluidez e legibilidade.
