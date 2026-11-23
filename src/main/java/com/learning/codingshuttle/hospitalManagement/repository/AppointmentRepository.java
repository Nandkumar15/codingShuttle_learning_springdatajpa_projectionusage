package com.learning.codingshuttle.hospitalManagement.repository;

import com.learning.codingshuttle.hospitalManagement.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}