# Sistema de Cadastro de Pessoas

## Introdução
Este projeto é um sistema de cadastro de pessoas desenvolvido como parte de um desafio técnico. Ele utiliza tecnologias como Java, JSF, PrimeFaces, Hibernate, EJB, e PostgreSQL, integradas em um ambiente Maven. A aplicação permite realizar operações CRUD (Create, Read, Update, Delete) em registros de pessoas.

## Decisões Técnicas e Arquiteturais

### Arquitetura
Optamos por uma arquitetura baseada em camadas para separar as responsabilidades e facilitar a manutenção do código:
- **Camada de Apresentação**: Utiliza JSF e PrimeFaces para construir a interface do usuário.
- **Camada de Negócio**: Implementada com EJB para gerenciar a lógica de negócios.
- **Camada de Persistência**: Utiliza Hibernate para a interação com o banco de dados PostgreSQL.
- **Camada de Dados**: PostgreSQL é usado como banco de dados relacional para armazenar os dados.

### Definições

- **DAO (Data Access Object)**: A camada DAO é responsável pela interação com o banco de dados. Ele abstrai e encapsula todas as operações de acesso aos dados, como consultas, inserções, atualizações e deleções. No nosso projeto, temos o `PessoaDAO` e o `EnderecoDAO`.
  
- **MB (Managed Bean)**: Os Managed Beans são controladores na arquitetura JSF. Eles gerenciam a interação entre a camada de apresentação e a camada de negócios. No nosso projeto, utilizamos `UsuarioPessoaManagedBean` e `EnderecoManagedBean` para lidar com a lógica da interface de usuário.
  
- **EJB (Enterprise JavaBeans)**: EJBs são componentes de servidor que encapsulam a lógica de negócios. Eles são usados para desenvolver aplicações empresariais escaláveis, transacionais e seguras. No projeto, `PessoaService` e `EnderecoService` são exemplos de EJBs que implementam a lógica de negócios.
  
- **Model**: A camada de modelo contém as classes de entidade que representam os dados do sistema. Elas são mapeadas para tabelas do banco de dados utilizando JPA/Hibernate. No nosso projeto, `Pessoa` e `Endereco` são as entidades de modelo.

### Justificativa para Uso de Frameworks e Bibliotecas
- **JSF**: Escolhido pela facilidade de integração com PrimeFaces e por ser um padrão para aplicações Java web.
- **PrimeFaces**: Proporciona uma ampla gama de componentes ricos e prontos para uso, facilitando a criação de uma interface de usuário moderna e responsiva.
- **Hibernate**: Simplifica o mapeamento objeto-relacional, permitindo que as entidades Java sejam mapeadas diretamente para tabelas do banco de dados.
- **EJB**: Fornece um modelo robusto para a implementação da lógica de negócios, suportando transações e segurança de forma nativa.
- **PostgreSQL**: Escolhido por sua robustez, conformidade com padrões SQL e recursos avançados.

## Instruções para Compilar e Executar o Projeto

### Pré-requisitos
- **Java 8**: Certifique-se de que o Java 8 está instalado e configurado no seu PATH.
- **Maven**: Necessário para gerenciar as dependências e construir o projeto.
- **PostgreSQL**: Banco de dados relacional. Certifique-se de que está instalado e em execução.

### Configuração do Banco de Dados
1. Crie um banco de dados e um usuário no PostgreSQL:
   ```sql
   CREATE DATABASE cadastro_pessoas;
   CREATE USER usuario_cadastro WITH PASSWORD 'senha_cadastro';
   GRANT ALL PRIVILEGES ON DATABASE cadastro_pessoas TO usuario_cadastro;
   
2. Configure o datasource no servidor de aplicações (exemplo para Tomcat), adicionando a seguinte configuração no arquivo context.xml do Tomcat:

<Context>
    <Resource name="jdbc/PostgresDS" auth="Container" type="javax.sql.DataSource"
              maxTotal="20" maxIdle="10" maxWaitMillis="-1"
              username="usuario_cadastro" password="senha_cadastro"
              driverClassName="org.postgresql.Driver"
              url="jdbc:postgresql://localhost:5432/cadastro_pessoas"/>
</Context>

### Compilar e Executar

1. Clone o repositório do projeto:

-> git clone https://github.com/seu-usuario/cadastro-pessoas.git
-> cd cadastro-pessoas

2. Compile o projeto com Maven:

-> mvn clean install

3. Gere o arquivo WAR:

-> mvn package

### Executar os Testes

1. Para executar os testes, utilize o seguinte comando Maven:

-> mvn test



### Estrutura de Pastas

Estrutura de pastas do projeto:

cadastro-pessoas/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── com/
│ │ │ │ ├── everson/
│ │ │ │ │ ├── crud/
│ │ │ │ │ │ ├── model/
│ │ │ │ │ │ │ ├── Pessoa.java
│ │ │ │ │ │ │ ├── Endereco.java
│ │ │ │ │ │ ├── dao/
│ │ │ │ │ │ │ ├── PessoaDAO.java
│ │ │ │ │ │ │ ├── EnderecoDAO.java
│ │ │ │ │ │ ├── service/
│ │ │ │ │ │ │ ├── PessoaService.java
│ │ │ │ │ │ │ ├── EnderecoService.java
│ │ │ │ │ │ ├── managedBean/
│ │ │ │ │ │ │ ├── UsuarioPessoaManagedBean.java
│ │ │ │ │ │ │ ├── EnderecoManagedBean.java
│ │ ├── resources/
│ │ │ ├── META-INF/
│ │ │ │ ├── persistence.xml
│ │ ├── webapp/
│ │ │ ├── WEB-INF/
│ │ │ │ ├── web.xml
│ │ │ ├── templates/
│ │ │ │ ├── index.xhtml
│ │ │ │ ├── cadastro.xhtml
│ ├── test/
│ │ ├── java/
│ │ │ ├── com/
│ │ │ │ ├── everson/
│ │ │ │ │ ├── crud/
│ │ │ │ │ │ ├── PessoaBeanTest.java
│ │ │ │ │ │ ├── EnderecoBeanTest.java
├── pom.xml
├── README.md

Autor: [Everson Mariano]


