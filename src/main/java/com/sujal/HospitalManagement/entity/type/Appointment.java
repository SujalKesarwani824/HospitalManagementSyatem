package com.sujal.HospitalManagement.entity.type;

import com.sujal.HospitalManagement.entity.Doctor;
import com.sujal.HospitalManagement.entity.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne // Many appointment to One Patient
    @ToString.Exclude
    @JoinColumn(name = "patient_id", nullable = false) // Patient is required and not nullable
    private Patient patient;

    @ManyToOne  // many to one mai fetchType.eager hai toh yeh fetch kar lega Doctor ko bhi aur Patient ko bhi ho jaayega koi error nhi aayega
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Doctor doctor;
}


