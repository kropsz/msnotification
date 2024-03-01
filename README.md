# Microserviço de Usuários (CompassUOL)
O projeto foi desenvolvido para o desafio 3 do programa de Bolsas da Compass UOL | Back-end Journey (Spring Boot) - AWS Cloud Context. Esse é um microserviço para receber e guardar informações de eventos do microserviço [msuser](https://github.com/kropsz/msuser). Quando algum evento como o de registro, login, atualização de usuário e atualização de senha é utilizado no msuser esse microserviço recebe a mensagem via RabbitMQ e a armazena no banco de dados.

## Tecnologias Utilizadas
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

### Dependências
Gerenciador de Dependências : Maven

- Spring Boot 3
- Spring Web
- Spring Doc OpenAPI Swagger
- Spring DevTools
- Lombok
- ModelMapper
- Mockito
- JUnit 5
- Banco de dados MongoDB

## Endpoints

* `GET`  - `/notify` - Listar todas as notificações de eventos 

* `RESPONSE`  - Utilizado para retorno de informações de um EVENTO.
```JSON
{
  "email": "maria@email.com",
  "event": "LOGIN",
  "date": "ISO-8601 DATE"
}

```

# Como executar o projeto
### JDK 17
O projeto foi desenvolvido com a linguagem Java, fazendo uso do Java Development Kit (JDK) versão 17. Assim, para rodar o projeto, é necessário ter o JDK 17 instalado no seu computador. Você pode fazer o download do mesmo através do link fornecido -> [Download Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).

### Escolha a sua IDE:
* VSCode
* IntelliJ
* Spring Tools 4 (Eclipse)
  
### Configurações de Banco de Dados
É necessário  configurar o banco de dados MongoDB:
Navegue até a pasta  `src/main/resources` onde está o arquivo `application.yml` e altere as propriedades:
<div>
<img src="https://github.com/kropsz/compassuol-challenge-e-commerce/assets/114687669/29a9dee6-3bc8-4d97-ace1-14f354fd78d8" width="500px" />
</div>

 Substitua as variáveis de ambiente pelos seus dados de acesso ao Banco de Dados: 

### Docker Compose
No terminal navegue até a pasta raiz do projeto e execute o comando `docker-compose up -d` para poder executar o MongoDB e o RabbitMQ via Docker

> [!WARNING]<br>
> Caso encontre algum problema para utilizar o docker compose utilize os comandos separados no terminal.

> **Docker command MongoDB**: `docker run -it --network some-network --rm mongo mongosh --host some-mongo test`

>  **Docker command MongoDB**: `docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management`

### Conclusão

O microseviço de notificação trabalha em conjunto com o microserviço msuser, recebendo e armazenando eventos de usuário como registro, login e atualizações de dados. A comunicação entre os serviços é feita através do RabbitMQ, e os dados são armazenados em um banco de dados. Este projeto demonstra uma arquitetura de microserviços eficiente e a utilização de tecnologias modernas para a comunicação entre serviços e armazenamento de dados.
