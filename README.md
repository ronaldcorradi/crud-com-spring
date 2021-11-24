# Crud básico com Spring

### Tecnologias utilzadas
* Spring Boot
* Java 8
* Spring MVC
* Spring Web
* H2
* 
#### Descrição
Esse projeto foi desenvolvido para fins didáticos apresentado um CRUD simples utilizando Spring, Java e o banco de dados H2.

### Estrutura do projeto
A classe Pessoa no pacote model, irá representar a tabela no Banco de Dados.
A interface PessoaRepository no pacote repositories tem como responsabilidade acessar o banco de dados.
A classe PessoaService no pacote services concentrará a ógica relacionada aos negócios. É essa classe que será a facilitadora no acesso dos Models e com isso, o Controller passará a enxergar a Service e o repository fica encapsulado nela.
A classe PessoaController tem a responsabilidade tanto por receber requisições como por enviar a resposta ao usuário.
A classes do pacote dto e form são responsáveis por representar a Entidade, evitando que trabalhemos diretamente com elas. As classes do pacote dto exibem a resposta de uma requisição e as do pacote form ficam responsáveis por simular um formulário e estão sendo utilizadas nos métodos POST e PUT.
