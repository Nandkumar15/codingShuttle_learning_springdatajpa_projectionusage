package com.learning.codingshuttle.hospitalManagement;

import com.learning.codingshuttle.hospitalManagement.dto.BloodGroupStats;
import com.learning.codingshuttle.hospitalManagement.dto.CPatientInfo;
import com.learning.codingshuttle.hospitalManagement.dto.IPatientInfo;
import com.learning.codingshuttle.hospitalManagement.entities.Patient;
import com.learning.codingshuttle.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;



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

       int updatedRow=patientRepository.updatePatientNameById( "Mukul Gautam",4L);
       System.out.println(updatedRow);
    }
}
