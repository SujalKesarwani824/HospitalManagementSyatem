package com.sujal.HospitalManagement;

import com.sujal.HospitalManagement.entity.Insurance;
import com.sujal.HospitalManagement.entity.Patient;
import com.sujal.HospitalManagement.entity.type.Appointment;
import com.sujal.HospitalManagement.service.AppointmentService;
import com.sujal.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {

        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);


//        One more method is written

        var newPatient = insuranceService.dissacociateInsuramnceFromPatient(patient.getId());
        System.out.println(newPatient);

    }

    @Test
    public void testCreateAppointment() {

        Appointment appointment = Appointment.builder().
                appointmentTime(LocalDateTime.of(2025,11,1,14,0))
                .reason("Fever")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment,1L,1L);
        System.out.println(newAppointment);


        // one more method is used here up and down
        var updateAppointment = appointmentService.reAssignAppointmentToDoctor(newAppointment.getId(), 3L);
        System.out.println(updateAppointment);

    }



}
