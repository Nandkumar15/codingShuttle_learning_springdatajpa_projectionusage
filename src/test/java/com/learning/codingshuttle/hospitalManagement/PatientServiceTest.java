package com.learning.codingshuttle.hospitalManagement;

import com.learning.codingshuttle.hospitalManagement.dto.BloodGroupStats;
import com.learning.codingshuttle.hospitalManagement.dto.CPatientInfo;
import com.learning.codingshuttle.hospitalManagement.dto.IPatientInfo;
import com.learning.codingshuttle.hospitalManagement.entities.Patient;
import com.learning.codingshuttle.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;



    @Transactional
    @Test
    public void testPatient(){

       // List<Patient> patientList=patientRepository.findAll();
     //  List<IPatientInfo> patientList=patientRepository.getPatientInfo();

        //List<CPatientInfo> patientList=patientRepository.getAllPatientInfoUsingConcreate();

//        List<BloodGroupStats> patientList=patientRepository.getBloodGroupStats();

//      for (var p : patientList) {
//           System.out.println("patient id is:"+p.getId());
//          System.out.println("patient name is:"+p.getName());
//          System.out.println("patient email is:"+p.getEmail());
//       }

//       int updatedRow=patientRepository.updatePatientNameById( "Mukul Gautam",4L);
//       System.out.println(updatedRow);
       //this is n+1 query problem
//        List<Patient>patient =patientRepository.findAllByAppointment();
//        for(var p:patient){
//            System.out.println(p);
//        }

        //N+1 query optimization solution fetch type is lazy for appointments in patient entity
//        List<Patient>patient =patientRepository.getAllPatientWithAppointments();
//        for(var p:patient){
//           System.out.println(p);
//        }

        List<Patient>patient =patientRepository.findAll();
        for(var p:patient){
            System.out.println(p);
        }

    }
}
