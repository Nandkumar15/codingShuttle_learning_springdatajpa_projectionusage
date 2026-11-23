package com.learning.codingshuttle.hospitalManagement.repository;

import com.learning.codingshuttle.hospitalManagement.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}