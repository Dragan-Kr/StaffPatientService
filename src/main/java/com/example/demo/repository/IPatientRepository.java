package com.example.demo.repository;

import com.example.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "SELECT * from Patient WHERE wid = ?1", nativeQuery = true)
    Collection<Patient> findByWard(Integer ward);
}
