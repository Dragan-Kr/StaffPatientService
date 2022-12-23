package com.example.demo.impl;


import com.example.demo.dtos.StaffDTO;
import com.example.demo.dtos.StaffModificationDTO;
import com.example.demo.entities.Staff;
import com.example.demo.entities.StaffPK;
import com.example.demo.repository.IStaffRepository;
import com.example.demo.services.PersonService;
import com.example.demo.services.StaffService;
import com.example.demo.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Optional;

@Service
public class StaffServiceImplem implements StaffService {

    @Autowired
    private IStaffRepository staffRepository;

    @Autowired
     private PersonService personService;

    @Autowired
    private WardService wardService;



    RestTemplate restTemplate = new RestTemplate();
    String restURI = "http://localhost:8080/ward";
    String restPersonURI = "http://localhost:8081/person";

    @Override
    public StaffDTO getStaffById(Integer id, Integer wardid) {
        Staff foundStaff = staffRepository.findById(new StaffPK(id,wardid)).get();
        foundStaff.setId(personService.getPersonById(foundStaff.getId()));
        foundStaff.setWardid((wardService.getWardById(foundStaff.getWardid())).getId());
        StaffDTO mappedStaff = new StaffDTO(foundStaff.getId(), foundStaff.getWardid(),foundStaff.getEducation(),foundStaff.getForen_languages(),foundStaff.getJoined());
        return mappedStaff;
    }

    @Override
    public Collection<Staff> findAllObjects() {
        return staffRepository.findAll();
    }

    @Override
    public StaffDTO insert(StaffModificationDTO staff) {
        Staff newStaff = new Staff();
        newStaff.setId(staff.getId());
        newStaff.setWardid(staff.getWardid());
        newStaff.setJoined(staff.getJoined());
        newStaff.setEducation(staff.getEducation());
        newStaff.setForen_languages(staff.getForen_languages());
        newStaff = staffRepository.save(newStaff);
        StaffDTO mappedStaff = new StaffDTO(newStaff.getId(), newStaff.getWardid(), newStaff.getEducation(), newStaff.getForen_languages(),newStaff.getJoined());
        return  mappedStaff;
    }

    @Override
    public StaffDTO update(StaffModificationDTO staff, Integer id, Integer wardid) {
        Staff updatedStaff = staffRepository.findById(new StaffPK(id,wardid)).map(oldStaff ->{
            oldStaff.setEducation(staff.getEducation());
            oldStaff.setForen_languages(staff.getForen_languages());
            oldStaff.setJoined(staff.getJoined());
            return  staffRepository.save(oldStaff);

        }).get();
//        updatedStaff.setPerson(personService.getPersonById(updatedStaff.getId()));
//        updatedStaff.setWard(wardService.getWardById(updatedStaff.getWardid()));
        StaffDTO mappedStaff = new StaffDTO(updatedStaff.getId(),updatedStaff.getWardid(),updatedStaff.getEducation(),updatedStaff.getForen_languages(),updatedStaff.getJoined());
        return  mappedStaff;
    }

    @Override
    public void delete(Integer id, Integer wardid) {
      staffRepository.deleteById(new StaffPK(id,wardid));
    }



//
//    @Override
//    public Collection<Staff> findAllObjects() {
//        return staffRepository.findAll();
//    }
//
//
//
//    @Override
//    public Collection<Staff> findByWard(Integer ward) {
//        return staffRepository.findByWard(ward);
//    }
//
//    @Override
//    public ResponseEntity<Staff> create(Staff s) {
//       if(!getWard(s.getId()).equals((HttpStatus.OK)))
//           return  new ResponseEntity<Staff>(HttpStatus.BAD_REQUEST);
//       if(staffRepository.existsById((s.getId()))){
//           return  new ResponseEntity<Staff>(HttpStatus.BAD_REQUEST);
//       }
//       staffRepository.save(s);
//       return new ResponseEntity<Staff>(HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<Staff> update(Staff s) {
//        if(!getWard(s.getId()).equals((HttpStatus.OK)))
//            return  new ResponseEntity<Staff>(HttpStatus.BAD_REQUEST);
//        if(!staffRepository.existsById((s.getId()))){
//            return  new ResponseEntity<Staff>(HttpStatus.BAD_REQUEST);
//        }
//        staffRepository.save(s);
//        return new ResponseEntity<Staff>(HttpStatus.OK);
//    }
//
//
//
//    @Override
//    public Collection<Staff> findByPerson(Integer person) {
//        return staffRepository.findByPerson(person);
//    }
//
//
//
//

    private HttpStatus getWard(StaffPK staffPK) {
        return restTemplate.getForEntity(restURI + "/" + staffPK.getWardid(), String.class).getStatusCode();
    }

    private HttpStatus getPerson(StaffPK staffPK){
      return   restTemplate.getForEntity(restPersonURI + "/" + staffPK.getId(),String.class).getStatusCode();
    }


}
