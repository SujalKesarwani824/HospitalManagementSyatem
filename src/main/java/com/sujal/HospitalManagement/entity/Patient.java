package com.sujal.HospitalManagement.entity;

import com.sujal.HospitalManagement.entity.type.Appointment;
import com.sujal.HospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(

        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "Unique_patient_birthdate_name", columnNames = {"birthDate", "name"})
        },
        indexes = {
                @Index(name = "patient_birth_date", columnList = "birthDate") // for multiple column "birthDate, name"
        }


)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    // @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST},orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;


    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>();


}
