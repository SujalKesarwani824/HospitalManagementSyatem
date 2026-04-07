package com.sujal.HospitalManagement.repository;

import com.sujal.HospitalManagement.entity.type.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}