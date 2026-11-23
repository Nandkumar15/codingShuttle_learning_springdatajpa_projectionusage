package com.learning.codingshuttle.hospitalManagement.service;

import com.learning.codingshuttle.hospitalManagement.entities.Patient;
import com.learning.codingshuttle.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }


}
