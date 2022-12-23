package com.example.demo.repository;

import com.example.demo.dtos.StaffDTO;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Staff;
import com.example.demo.entities.StaffPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IStaffRepository extends JpaRepository<Staff, StaffPK> {

//    @Query(value = "SELECT * from Staff WHERE wardid = ?1  ", nativeQuery = true)
//    Collection<Staff> findByWard(Integer ward);
//
//    boolean existsById(StaffPK id);
//
//    @Query(value = "SELECT * from Staff WHERE id = ?1  ", nativeQuery = true)
//    Collection<Staff> findByPerson(Integer person);


}
