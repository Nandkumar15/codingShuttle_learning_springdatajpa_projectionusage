package com.learning.codingshuttle.hospitalManagement.repository;

import com.learning.codingshuttle.hospitalManagement.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}