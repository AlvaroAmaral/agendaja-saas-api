package com.alvaro.agendaja.scheduling_api;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("Não deve permitir agendamento no passado")
    public void deveRetornarErroAoAgendarNoPassado() {
        String json = """
            {
                "tenantId": "itu-tech",
                "customerName": "Teste QA",
                "startTime": "2023-01-01T10:00:00",
                "endTime": "2023-01-01T11:00:00"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/api/appointments")
                .then()
                .statusCode(400)
                .body("message", equalTo("Não é permitido realizar agendamentos em datas passadas."));
    }

    @Test
    @DisplayName("Deve garantir isolamento de dados entre empresas (Tenants)")
    public void deveGarantirIsolamentoEntreTenants() {
        // Tenta mudar o status de um ID passando o tenantId errado
        given()
                .queryParam("status", "CANCELLED")
                .queryParam("tenantId", "empresa-invasora")
                .when()
                .patch("/api/appointments/1/status")
                .then()
                .statusCode(400)
                .body("message", equalTo("Agendamento não encontrado para este cliente."));
    }
}