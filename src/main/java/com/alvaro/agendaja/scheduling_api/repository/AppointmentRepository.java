package com.alvaro.agendaja.scheduling_api.repository;

import com.alvaro.agendaja.scheduling_api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Método para buscar agendamentos de empresa específica
    List<Appointment> findByTenantId(String tenantId);
}
