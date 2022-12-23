package com.example.demo.services;


import com.example.demo.dtos.StaffDTO;
import com.example.demo.dtos.StaffModificationDTO;
import com.example.demo.entities.Staff;

import java.util.Collection;

public interface StaffService {
   public StaffDTO getStaffById(Integer id, Integer wardid);

    Collection<Staff> findAllObjects();

    StaffDTO insert(StaffModificationDTO staff);

    StaffDTO update(StaffModificationDTO staff, Integer id, Integer wardid);

    void delete(Integer id, Integer wardid);

//
//    Collection<Staff> findAllObjects();
//
//
//
//    Collection<Staff> findByWard(Integer ward);
//
//    ResponseEntity<Staff> create(Staff staff);
//
//    ResponseEntity<Staff> update(Staff staff);
//
//
//    Collection<Staff> findByPerson(Integer person);

}
