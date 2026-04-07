package com.sujal.HospitalManagement.service;

import com.sujal.HospitalManagement.entity.Patient;
import com.sujal.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

//    👉 Service is using repository
//👉 Not extending it
//👉 Not overriding it
//    This is called composition, not inheritance.

    @Transactional
    public Patient getPatientById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();

     // p1 and p2 will be the same object because of this @Transactional
     //  These object are refrencing the same place(They are not made again only once) because of persistent context
//        EntityManager hi hai joh humaare Database ke through saare operation kar raha hai yeh joh opertion karta woh store karta hai unka result persistentcontext ke andar
//        Aur EntityManager ka use karti hai humaari Repository ; Repository ke through hum kaam kar paate hai(Hum yaha EntityManager ke through kaam na karke Repository ke through kar rahe hai)
//        private final EntityManager entitymanager ke through bhi kar sakte hai
        System.out.println(p1 == p2);

        p1.setName("Yoyo");  // Kyuki yeh transactional state mai hai toh agar koi bhi changes ho toh mujhe save karne kki zarrorat nhi hai apne aap hi update call ho jaayega mujhe yeh karne ki zaroorat nhi hai patientRepository.save(p1)
//        Bina save ko call kiye save  hojaayega(update) yeh khass baat hai @transactional ki
//        Yeh Dirtycheck hota hai during the commit phase toh usne dekha isko update karne ki zaroorat hai toh update query bhi run ho jaata hai
//        yeh Database ke andar save bhi ho jaata hai

//        With @Transactional
//
//✔ One transaction
//✔ One persistence context
//✔ First-level cache
//✔ Safe DB operations
//
//📌 Rule:
//
//        Service layer = best place for @Transactional

        return p1;

    }
}
