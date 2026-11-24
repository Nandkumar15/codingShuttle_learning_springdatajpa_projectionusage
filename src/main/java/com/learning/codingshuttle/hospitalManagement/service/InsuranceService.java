package com.learning.codingshuttle.hospitalManagement.service;

import com.learning.codingshuttle.hospitalManagement.entities.Insurance;
import com.learning.codingshuttle.hospitalManagement.entities.Patient;
import com.learning.codingshuttle.hospitalManagement.repository.InsuranceRepository;
import com.learning.codingshuttle.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional //to have a persistentContext inside this method
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){

        Patient patient=patientRepository.findById(patientId).orElseThrow();

        //as patient is owning the relationship
        // we need to add the insurance details in patient
        //this will also create an insurance data in db as well
        //auto save as we used the @Transitional in the db this dirty update
        //the insurance is transient at this time, we have to make is persistent so we will Cascading in Patient entity insurance field
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //this is optional to maintain Bidirectional
        return insurance;
    }
    @Transactional //to have a persistentContext inside this method
    public Insurance updateInsuranceOfPatient(Insurance insurance, Long patientId){

        Patient patient=patientRepository.findById(patientId).orElseThrow();

        //as patient is owning the relationship
        // we need to add the insurance details in patient
        //this will also create an insurance data in db as well
        //auto save as we used the @Transitional in the db this dirty update
        //the insurance is transient at this time, we have to make is persistent so we will Cascading in Patient entity insurance field
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //this is optional to maintain Bidirectional
        return insurance;
    }

    @Transactional //to have a persistentContext inside this method
    public Patient deleteInsuranceOfPatient(Long patientId){

        Patient patient=patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);
        return patient;
    }

    


}
