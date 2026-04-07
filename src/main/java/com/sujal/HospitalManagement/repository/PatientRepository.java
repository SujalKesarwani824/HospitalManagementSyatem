package com.sujal.HospitalManagement.repository;

import com.sujal.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.sujal.HospitalManagement.entity.Patient;
import com.sujal.HospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    JPA Query methods
//    Query methods hum  different type methods bana sakte hai
    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(BloodGroupType bloodGroup);

    @Query("SELECT p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("SELECT p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();


    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = : name where p.id = : id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);



    @Query("SELECT new com.sujal.HospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, "+" Count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroup();



}
