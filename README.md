# AgendaJá - Multitenant Scheduling SaaS

**AgendaJá** is a robust API developed with Java 21 and Spring Boot 3, designed to operate as a SaaS (Software as a Service) model. The system allows multiple companies (tenants) to manage their appointments in an isolated and secure manner within a single infrastructure.

## 🚀 Technical Highlights
* **Multitenant Architecture**: Logical data isolation using tenantId in all requests, ensuring a company never accesses another's data.
* **Advanced Business Rules**:  Automatic validations to prevent past-dated bookings, scheduling conflicts, and minimum service duration requirements.
* **Interactive Documentation**: API 100% documented with Swagger (OpenAPI), allowing quick and visual endpoint testing.
* **Software Quality**: Automated integration test suite using JUnit 5 and RestAssured, validating success flows and error scenarios.
* **Modern Infrastructure**: Containerized environment using Docker for the PostgreSQL database, ensuring portability.

## 📸 Visual Demonstration

### User Interface (Frontend)
Minimalist dashboard developed to validate scheduling operations and real-time state lifecycles.
![Dashboard do AgendaJá](./img/dashboard.png)

### Interactive Documentation (Swagger)
The API follows OpenAPI 3.0 standards, ensuring clear documentation and easy integration.
![Swagger UI](./img/swagger-api.png)

## 🛠️ Technologies Used

* **Backend**: Java 21, Spring Boot 3, Spring Data JPA, Lombok.
* **Database**: PostgreSQL 15 running via Docker.
* **Testing**: JUnit 5, RestAssured.
* **Documentation**: SpringDoc OpenAPI (Swagger).
* **Frontend**: HTML5 and Vanilla JavaScript.

## 📋 How to Run the Project

### 1. Requirements
* Java 21+
* Docker and Docker Compose
* Maven

### 2. Database Configuration
In the project root (or the /docker folder), run the command to start PostgreSQL:

```bash
docker-compose up -d
```

### 3. Running the API
```bash
mvn spring-boot:run
```

### 4. Accessing the Documentation
With the application running, go to: http://localhost:8080/swagger-ui.html

## 🧪 Software Quality and Automated Testing
To ensure the integrity of business rules and multitenant isolation, the project features an integration test suite using JUnit 5 and RestAssured. These tests validate everything from appointment creation to security constraints between different companies.
![Swagger UI](./img/testes-sucesso.png)
