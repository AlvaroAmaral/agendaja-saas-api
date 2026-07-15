[Português 🇧🇷](./README_pt.md) | [English 🇺🇸](./README.md)


# AgendaJá - SaaS Multitenant de Agendamentos

O **AgendaJá** é uma API robusta desenvolvida com Java 21 e Spring Boot 3, projetada para operar no modelo SaaS (Software as a Service). O sistema permite que múltiplas empresas (tenants) gerenciem seus agendamentos de forma isolada e segura dentro de uma única infraestrutura.

🌍 **Aplicação no Ar (Demo):** [Acesse o Dashboard aqui](https://agendaja-api.vercel.app/)
📖 **Documentação da API (Swagger):** [Acesse a API aqui](https://agendaja-wtt0.onrender.com/swagger-ui/index.html#/Agendamentos/getAll)

## 🚀 Destaques Técnicos
* **Arquitetura Multitenant**: Isolamento lógico de dados utilizando `tenantId` em todas as requisições, garantindo que uma empresa nunca acesse os dados de outra.
* **Regras de Negócio Avançadas**: Validações automáticas para impedir agendamentos retroativos, conflito de horários e exigência de duração mínima de serviços.
* **Qualidade de Software**: Suíte de testes de integração automatizados utilizando JUnit 5 e RestAssured, validando fluxos completos desde o endpoint até a persistência no banco.
* **Cloud & DevOps**: Aplicação totalmente conteinerizada com um `Dockerfile` customizado e hospedada em ambiente de nuvem, garantindo alta portabilidade e preparo para CI/CD.

## 📸 Demonstração Visual

### Interface de Usuário (Frontend)
Dashboard minimalista desenvolvido para validar as operações de agendamento e o ciclo de vida dos status em tempo real.
![Dashboard do AgendaJá](./img/dashboard.png)

### Documentação Interativa (Swagger)
A API segue o padrão OpenAPI 3.1, garantindo documentação clara e facilitando a integração entre equipes de desenvolvimento.
![Swagger UI](./img/swagger-api.png)

## 🛠️ Tecnologias e Infraestrutura

* **Backend**: Java 21, Spring Boot 3, Spring Data JPA.
* **Banco de Dados**: PostgreSQL 15 (Local via Docker Compose / Produção via banco Serverless Neon).
* **Testes**: JUnit 5, RestAssured.
* **Hospedagem Cloud**: Render (API Backend Conteinerizada), Vercel (Dashboard Frontend Estático).

## 📋 Como rodar o projeto localmente

### 1. Requisitos
* Java 21+
* Docker e Docker Compose
* Maven

### 2. Configuração do Banco de Dados
Na raiz do projeto (ou na pasta `/docker`), rode o comando para iniciar a instância local do PostgreSQL:

```bash
docker-compose up -d
```

### 3. Rodando a API
```bash
mvn spring-boot:run
```

### 4. Acessando a Documentação Local
Com a aplicação rodando localmente, acesse: http://localhost:8080/swagger-ui.html
