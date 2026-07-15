[Português 🇧🇷](./README_pt.md) | [English 🇺🇸](./README.md)

# AgendaJá - Multitenant Scheduling SaaS

**AgendaJá** is a robust API developed with Java 21 and Spring Boot 3, designed to operate as a SaaS (Software as a Service) model. The system allows multiple companies (tenants) to manage their appointments in an isolated and secure manner within a single infrastructure.

🌍 **Live Demo:** [Access the Dashboard here](https://agendaja-api.vercel.app/)
📖 **Live API Docs (Swagger):** [Access the API here](https://agendaja-wtt0.onrender.com/swagger-ui/index.html#/Agendamentos/getAll)

## 🚀 Technical Highlights
* **Multitenant Architecture**: Logical data isolation using `tenantId` in all requests, ensuring a company never accesses another's data.
* **Advanced Business Rules**: Automatic validations to prevent past-dated bookings, scheduling conflicts, and minimum service duration requirements.
* **Software Quality**: Automated integration test suite using JUnit 5 and RestAssured, validating full flows from endpoint to database persistence.
* **Cloud & DevOps**: The application is fully containerized using a custom `Dockerfile` and deployed in a cloud environment, ensuring high portability and CI/CD readiness.

## 📸 Visual Demonstration

### User Interface (Frontend)
Minimalist dashboard developed to validate scheduling operations and real-time state lifecycles.
![Dashboard do AgendaJá](./img/dashboard.png)

### Interactive Documentation (Swagger)
The API follows OpenAPI 3.1 standards, ensuring clear documentation and easy integration.
![Swagger UI](./img/swagger-api.png)

## 🛠️ Technologies & Infrastructure

* **Backend**: Java 21, Spring Boot 3, Spring Data JPA.
* **Database**: PostgreSQL 15 (Locally via Docker Compose / Production via Neon Serverless DB).
* **Testing**: JUnit 5, RestAssured.
* **Cloud Hosting**: Render (Dockerized API Backend), Vercel (Static Frontend Dashboard).

## 📋 How to Run the Project Locally

### 1. Requirements
* Java 21+
* Docker and Docker Compose
* Maven

### 2. Database Configuration
In the project root (or the `/docker` folder), run the command to start the local PostgreSQL instance:

```bash
docker-compose up -d
```

### 3. Running the API
```bash
mvn spring-boot:run
```

### 4. Accessing the Local Documentation
With the application running locally, go to: http://localhost:8080/swagger-ui.html
