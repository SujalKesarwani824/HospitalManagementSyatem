package com.sujal.HospitalManagement.service;


import com.sujal.HospitalManagement.entity.Insurance;
import com.sujal.HospitalManagement.entity.Patient;
import com.sujal.HospitalManagement.repository.InsuranceRepository;
import com.sujal.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;


    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId ) {

        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id "+patientId));

        patient.setInsurance(insurance); //we dont have to save this method manually  Because of when we return from this function beacuse of  @Transactional the dirty checking is being done and it checks not it has been dirtied so check whichever fields it depends upon find it if not there then create it and it automatically  call an update(save) // Because Transactional create insurance if it is not created and calls save
//        insurance save nhi hoga jab tak proper cascading rule define nhi karenge tab tak
//        Cascading ka matlab hota hai jab bhi Parent entity ke saath kuch bhi ho raha hai toh child entity kaise behave karni chaiye
//        jaise jab apne parent(Patient) ke andar remove operation karo child(Insurance)operation bhi remove ho jaaye yah jab parent save ho toh child bhi save ho jaaye

        insurance.setPatient(patient); // this is not required but we have just written to maintain bidirectional consistency// Because if in this transaction we require insurance so it could give me correct patientid

        return patient;

//        patient yaha save ho raha hai kyuki hum @Transactional context mai hai aur patient yaha dirty ho gaya hai
//        Transactional(method) bandh hua transactional commit phase mai chale jaayega fir dirty checking(woh dekhega patient toh update yaani dirty ho chuka hai) hoti hai
//        toh patient ke changes ko update karega database ke andar fir dekhega insurance update karna lekin insurance toh hai hi nhi Kyuki Cascading type merge hai toh pehle insurance ko save kiya jaayega fir uss insurance joh id milegi usse patient mai save kar diya jaayega fir patient ko update kar diya jaayega

    }


    @Transactional
    public Patient dissacociateInsuramnceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id "+patientId));

        patient.setInsurance(null);

        return patient;
    }


}
