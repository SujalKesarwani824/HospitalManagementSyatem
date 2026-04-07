package com.sujal.HospitalManagement;

import com.sujal.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.sujal.HospitalManagement.entity.Patient;
import com.sujal.HospitalManagement.entity.type.BloodGroupType;
import com.sujal.HospitalManagement.repository.PatientRepository;
import com.sujal.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

//        List<Patient> patientList2 = patientRepository.findAllPatientWithAppointment();
//        System.out.println(patientList2);


    }

    @Test
    public void testTransactionMethods() {
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);


//        Patient patient = patientRepository.findByName("Sujal Kesarwani");
//        System.out.println(patient); // we have to follow correct convection to write methods findByName
//
//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(2004,2,8),"sujalkesarwani824@gmail.com");
//        for (Patient p : patientList){
//            System.out.println(p); // we have to follow correct convection to write methods findByBirthDateOrEmail
//        }


//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        for(Patient patient : patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(2004,2,8));
//        for(Patient patient : patientList){
//            System.out.println(patient);
//        }


//        List<Object[]> patientlist = patientRepository.countEachBloodGroupType();
//        for (Object[] obj : patientlist) {
//            System.out.println(obj[0]+""+obj[1]);
//        }


//        List<Patient> patientList = patientRepository.findAllPatient();
//        for (Patient patient : patientList) {
//            System.out.println(patient);
//        }

//        int updatedRow = patientRepository.updateNameWithId("Suujal", 1L);
//        System.out.println(updatedRow);


//        Projection //
//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroup();
//        for (BloodGroupCountResponseEntity bloodGroupRes : bloodGroupList) {
//            System.out.println(bloodGroupRes);
//        }



//        Pagination //

//        Page<Patient> patientList = patientRepository.findAllPatient(PageRequest.of(0,2, Sort.by("name"))); // i can do sorting also
//        for (Patient patient : patientList) { // yeh by default mujhe Patient ka iterator laake dega iss Page iska joh iterator hota hai woh uske andar Data hi hota hai
//            System.out.println(patient); //Page ek container hai, data print karne ke liye uska content iterate karna padta hai
//        }




    }
}
