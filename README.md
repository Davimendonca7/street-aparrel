:shirt: Street Apparel - E-commerce de Roupas com Arquitetura de Microsserviços :shopping_cart:
Street Apparel é um projeto de e-commerce de roupas desenvolvido com uma arquitetura de microsserviços. O sistema foi projetado para ser escalável, modular e de fácil manutenção, utilizando tecnologias modernas para garantir desempenho, segurança e flexibilidade. A aplicação tem como objetivo fornecer uma plataforma de vendas online, permitindo que os usuários façam compras de roupas e gerenciem suas contas de forma eficiente.

:rocket: Funcionalidades
Autenticação e Autorização: Login com JWT, permitindo autenticação segura dos usuários. A validação de tokens e permissões é realizada pelo Gateway.
Microserviços: Arquitetura baseada em microsserviços com comunicação assíncrona utilizando RabbitMQ para integração entre os serviços.
Eureka Server: Gerenciamento e descoberta de microsserviços através do Eureka Server.
Gateway: O API Gateway centraliza o acesso às APIs, facilitando o roteamento e segurança das requisições.
Segurança: Proteção das APIs utilizando Spring Security com JWT para autenticação e autorização de usuários.
Containerização: Uso de Docker para garantir portabilidade e escalabilidade dos microsserviços.
:computer: Tecnologias Utilizadas
Spring Boot (para criação de microsserviços)
Eureka Server (para descoberta de microsserviços)
Spring Security (para segurança e autenticação)
JWT (para autenticação sem estado)
RabbitMQ (para comunicação assíncrona entre microsserviços)
Docker (para containerização dos serviços)
PostgreSQL (para persistência de dados)
:wrench: Estrutura do Projeto
Serviço de Usuário: Responsável por gerenciar o cadastro e autenticação dos usuários.
Serviço de Pedidos: Gerencia os pedidos de compra dos usuários.
Serviço de Produto: Gerencia os produtos disponíveis para compra no e-commerce.
Gateway: Centraliza as requisições de clientes para os microsserviços backend.
Eureka Server: Realiza a descoberta e registro dos microsserviços.
:arrow_forward: Como rodar o projeto
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/seu-usuario/street-apparel.git
Crie os containers Docker para os microsserviços e banco de dados:

bash
Copiar
Editar
docker-compose up
Acesse a aplicação:

O Gateway estará disponível em http://localhost:8080.
O Eureka Server estará disponível em http://localhost:8761.
:memo: Próximos Passos
Implementação de funcionalidades adicionais, como o gerenciamento de carrinho de compras.
Adição de mais microsserviços, como um serviço de pagamentos.
Melhorias de segurança, como a implementação de refresh tokens.
