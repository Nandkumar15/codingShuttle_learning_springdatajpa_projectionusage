package com.learning.codingshuttle.hospitalManagement;

import com.learning.codingshuttle.hospitalManagement.entities.Appointment;
import com.learning.codingshuttle.hospitalManagement.entities.Insurance;
import com.learning.codingshuttle.hospitalManagement.service.AppointmentService;
import com.learning.codingshuttle.hospitalManagement.service.InsuranceService;
import com.learning.codingshuttle.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;
@Test
    public void testAssingInsuranceToPatient(){
    Insurance insurance=Insurance.builder()
            .provider("HDFC ERGO")
            .policyNumber("HDFC_234G")
            .validTill(LocalDate.of(2028,04,15))
            .build();
   var updatedInsurance= insuranceService.assignInsuranceToPatient(insurance,1L);
    System.out.println(updatedInsurance);

    patientService.deletePatient(1L);
}

@Test
    public  void testCreateAppointement(){
    Appointment appointment=Appointment.builder()
            .appointmentTime(LocalDateTime.of(2026,11,25,1,5,12))
            .reason("Blood pressure")
            .build();
   var updatedAppointment= appointmentService.createNewAppointment(appointment,2L,1L);
    System.out.println(updatedAppointment);

    //if we delete the same patient 2 id , as appointment id =2 , it will delete
    //both patient and appointment. as the cascading is mentioned as all(persist,merge ,detach,remove etc.)
    // hence if we delete the parent the child will also be deleted.
    patientService.deletePatient(2L);
}

}
