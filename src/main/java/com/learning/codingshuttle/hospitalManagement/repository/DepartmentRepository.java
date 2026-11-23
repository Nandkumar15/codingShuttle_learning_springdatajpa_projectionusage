package com.learning.codingshuttle.hospitalManagement.repository;

import com.learning.codingshuttle.hospitalManagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}