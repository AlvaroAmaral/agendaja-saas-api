package com.alvaro.agendaja.scheduling_api.controller;

import com.alvaro.agendaja.scheduling_api.model.Appointment;
import com.alvaro.agendaja.scheduling_api.model.AppointmentStatus;
import com.alvaro.agendaja.scheduling_api.repository.AppointmentRepository;
import com.alvaro.agendaja.scheduling_api.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Agendamentos", description = "Gerenciamento de horários e status para o SaaS")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @Operation(summary = "Cria um novo agendamento", description = "Registra um agendamento validando conflitos de horário, datas passadas e duração mínima.")
    @PostMapping
    public Appointment create(@RequestBody Appointment appointment){
        return service.create(appointment);
    }

    //Listar todos os agendamentos (para teste)
    @Operation(summary = "Lista agendamentos por empresa", description = "Retorna todos os agendamentos filtrados obrigatoriamente pelo ID do Tenant.")
    @GetMapping
    public List<Appointment> getAll(@RequestParam String tenantId){
        return service.listAllByTenant(tenantId);
    }


    @Operation(summary = "Altera o status do agendamento", description = "Atualiza o estado (CONFIRMED, CANCELLED, etc) validando a posse do tenant e regras de transição.")
    @PatchMapping("/{id}/status")
    public Appointment changeStatus(
            @PathVariable Long id,
            @RequestParam AppointmentStatus status,
            @RequestParam String tenantId){
        return service.updateStatus(id, status, tenantId);
    }

}
