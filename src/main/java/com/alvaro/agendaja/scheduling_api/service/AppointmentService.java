package com.alvaro.agendaja.scheduling_api.service;

import com.alvaro.agendaja.scheduling_api.exception.BusinessException;
import com.alvaro.agendaja.scheduling_api.model.Appointment;
import com.alvaro.agendaja.scheduling_api.model.AppointmentStatus;
import com.alvaro.agendaja.scheduling_api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment create(Appointment appointment){
        // Validação Data no passado
        if (appointment.getStartTime().isBefore(LocalDateTime.now())){
            throw new BusinessException("Não é permitido realizar agendamentos em datas passadas.");
        }

        // Validação Início depois do Fim
        if(appointment.getStartTime().isAfter(appointment.getEndTime())){
            throw new BusinessException("O horário de início não pode ser posterior ao horário de término.");
        }

        // Validação Duração mínima (30min)
        long duration = java.time.Duration.between(appointment.getStartTime(), appointment.getEndTime()).toMinutes();
        if (duration < 30){
            throw new BusinessException("A duração mínima para qualquer serviço é de 30 minutos.");
        }

        // Verificação de conflito
        boolean conflict = repository.findByTenantId(appointment.getTenantId()).stream()
                .anyMatch(existing -> appointment.getStartTime().isBefore(existing.getEndTime()) &&
                appointment.getEndTime().isAfter(existing.getStartTime()));

        if(conflict){
            throw new BusinessException("Horário indisponível para este cliente.");
        }

        return repository.save(appointment);

    }

    public List<Appointment> listAllByTenant(String tenantId){
        if (tenantId == null || tenantId.isEmpty()){
            throw new BusinessException("O identificador da empresa (tenantId) é obrigatório.");
        }
        return repository.findByTenantId(tenantId);
    }

    public Appointment updateStatus(Long id, AppointmentStatus newStatus, String tenantId){
        // Busca o agendamento e valida se pertence ao tenant
        Appointment appointment = repository.findById(id)
                .filter(a -> a.getTenantId().equals(tenantId))
                .orElseThrow(() -> new BusinessException("Agendamento não encontrado para este cliente."));

        // Validar transições proibidas
        if (appointment.getStatus() == AppointmentStatus.CANCELLED){
            throw new BusinessException("Não é possível cancelar um serviço que já foi concluído");
        }

        appointment.setStatus(newStatus);
        return repository.save(appointment);
    }
}
