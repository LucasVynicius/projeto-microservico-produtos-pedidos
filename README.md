<<<<<<< HEAD
# Sistema de Gerenciamento de Produtos e Pedidos - Microsserviços e APIs

Este projeto implementa um sistema de gerenciamento de produtos e pedidos, seguindo as boas práticas de microsserviços, com API Gateway, Service Registry e comunicação entre serviços utilizando **OpenFeign**. O sistema permite realizar operações CRUD em produtos e pedidos, validando a disponibilidade dos produtos antes da criação de novos pedidos.

## Arquitetura

O sistema foi dividido em dois microsserviços principais:

1. **Produto Microservice**: Responsável por gerenciar os produtos, com operações de CRUD.
2. **Pedido Microservice**: Responsável por gerenciar os pedidos, verificando a disponibilidade de produtos no microsserviço de produtos antes de criar um novo pedido.

Além disso, o projeto inclui:

- **API Gateway**: Atua como ponto de entrada unificado para o ecossistema de microsserviços.
- **Service Registry e Service Discovery**: Implementados para registrar e descobrir microsserviços dinamicamente. Esses componentes garantem que os serviços possam se comunicar corretamente.

## Requisitos Implementados

### Funcionalidades dos Microsserviços

1. **Produto Microservice**:
   - CRUD (Create, Read, Update, Delete) de produtos.
   - Cada produto possui uma quantidade disponível que é utilizada para verificar a disponibilidade de estoque.

2. **Pedido Microservice**:
   - CRUD de pedidos.
   - Cada pedido tem um único produto associado.
   - Antes de criar um pedido, o serviço de pedidos verifica com o serviço de produtos se há estoque disponível para o produto.
   - Caso o produto esteja disponível, a quantidade é reduzida no serviço de produtos e o pedido é criado com status "pendente".

### Comunicação entre Microsserviços

- A comunicação entre o **Pedido Microservice** e o **Produto Microservice** é feita utilizando **OpenFeign**.
- Quando um cliente envia uma requisição para criar um pedido, o **Pedido Microservice** faz uma chamada ao **Produto Microservice** para verificar a disponibilidade do produto com base na quantidade em estoque.
- Se o produto estiver disponível, a quantidade é decrementada e o pedido é registrado no banco de dados.

### Fluxo de Criação de Pedido

1. O cliente envia uma requisição para o **Pedido Microservice** para criar um novo pedido.
2. O **Pedido Microservice** valida os dados do pedido.
3. O **Pedido Microservice** consulta o **Produto Microservice** para verificar a quantidade disponível do produto.
4. Se o produto estiver disponível (quantidade > 0):
   - O **Produto Microservice** reduz a quantidade do produto no banco de dados.
   - O **Pedido Microservice** persiste o novo pedido com status "pendente".
5. Se o produto não estiver disponível, o **Pedido Microservice** retorna uma resposta de erro ao cliente.

## Estrutura de Pastas

O projeto está dividido nos seguintes pacotes e camadas para cada microsserviço:

- **model**: Define as classes de modelo do banco de dados (entidades).
- **repository**: Interface responsável pela comunicação com o banco de dados.
- **dto**: Objetos de transferência de dados (Data Transfer Objects) usados para comunicação entre as APIs e o cliente.
- **service**: Implementa a lógica de negócios dos microsserviços.
- **controller**: Controladores que lidam com as requisições HTTP e retornam as respostas.

## Tecnologias Utilizadas

- **Java** com **Spring Boot**: Para implementar os microsserviços e camadas do sistema.
- **Spring Cloud Netflix (Eureka)**: Para implementar o Service Registry e Service Discovery.
- **Spring Cloud Gateway**: Para implementar o API Gateway.
- **OpenFeign**: Para comunicação entre os microsserviços.
- **Spring Data JPA**: Para comunicação com o banco de dados.
- **H2 Database** (ou outro banco de dados de sua escolha): Para persistência dos dados de produtos e pedidos.

## Como Executar o Projeto

1. Clone este repositório em sua máquina.
2. Navegue até o diretório raiz e execute os seguintes comandos para iniciar os microsserviços e o ambiente:
   
   ```bash
   ./mvnw clean install
=======
# projeto-microservico-produtos-pedidos
>>>>>>> 80c50c8da51772e115a405c51defa4a9935d019d
