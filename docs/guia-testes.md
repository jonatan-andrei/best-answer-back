# Guia de testes implementados no projeto

## Testes integrados

#### CadastroControllerTest.cadastrarCliente
* Descrição: Cadastra um cliente e verifica se a aplicação retorna um token.
* Relacionado a funcionalidade: Cadastro de cliente

#### CadastroControllerTest.tentarCadastrarClienteJaCadastrado
* Descrição: Tenta cadastrar cliente com e-mail já utilizado em outro cadastro e verifica se a aplicação valida isso.
* Relacionado a funcionalidade: Cadastro de cliente

#### LoginControllerTest.loginValido
* Descrição: Realiza login na aplicação e verifica se um token é retornado.
* Relacionado a funcionalidade: Login

#### LoginControllerTest.loginInvalido
* Descrição: Tenta realizar o login com um usuário que nunca foi cadastrado. Verifica se a aplicação retorna erro.
* Relacionado a funcionalidade: Login

#### ProdutoControllerTest.listarProdutos
* Descrição: Insere dois produtos na base de dados e testa se estes produtos são encontrados na base de dados.
* Relacionado a funcionalidade: Listagem de produtos

#### ProdutoControllerTest.cadastrarProduto
* Descrição: Cadastra um produto na base de dados e para garantir que o produto foi salvo, busca ele na base de dados.
* Relacionado a funcionalidade: Cadastro de produto

#### ProdutoControllerTest.buscarPorId
* Descrição: Insere um produto na base e busca este produto pelo seu código. Verifica se encontrou o produto.
* Relacionado a funcionalidade: Visualizar produto

## Testes unitários

#### ClienteServiceTest.cadastrarComSucesso
* Descrição: Testa se método responsável por inserir o cliente na base de dados é chamado
* Relacionado a funcionalidade: Cadastro de cliente

#### VendedorServiceTest.cadastrarComSucesso
* Descrição: Testa se método responsável por inserir o vendedor na base de dados é chamado
* Relacionado a funcionalidade: Cadastro de vendedor

#### ProdutoServiceTest.cadastrar
* Descrição: Testa se o método responsável por inserir o produto na base de dados é chamado
* Relacionado a funcionalidade: Cadastro de produto

#### ProdutoServiceTest.listar
* Descrição: Testa se o método responsável por listar os produtos cadastrados é chamado
* Relacionado a funcionalidade: Listagem de produtos

#### ProdutoServiceTest.buscarPorId
* Descrição: Testa se o método responsável por buscar um produto na base de dados é chamado
* Relacionado a funcionalidade: Visualizar produto