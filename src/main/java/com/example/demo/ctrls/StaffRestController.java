package com.example.demo.ctrls;

import com.example.demo.dtos.StaffDTO;
import com.example.demo.dtos.StaffModificationDTO;
import com.example.demo.entities.Staff;
import com.example.demo.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@CrossOrigin(origins = "http://localhost:8083")
@RestController
public class StaffRestController {

    @Autowired
    private StaffService staffService;


    public StaffService getStaffService(){
        return staffService;
    }

    public  void  setStaffService(StaffService staffService){
        this.staffService = staffService;
    }

    @GetMapping( "staff/{id}/{wardid}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable("id") Integer id, @PathVariable("wardid") Integer wardid)
    {
        return ResponseEntity.ok(staffService.getStaffById(id,wardid));
    }

    @PostMapping("staff")
    public ResponseEntity<StaffDTO> insertAssembly(@RequestBody StaffModificationDTO staff)
    {
        return ResponseEntity.ok(staffService.insert(staff));
    }


    @PutMapping("staff/{id}/{wardid}")
    public ResponseEntity<StaffDTO> updateStaff(@RequestBody StaffModificationDTO staff,@PathVariable("id") Integer id,@PathVariable("wardid") Integer wardid)
    {
        return ResponseEntity.ok(staffService.update(staff,id,wardid));
    }



    @DeleteMapping("staff/{id}/{wardid}")
    public ResponseEntity deleteStaff(@PathVariable("id") Integer id,@PathVariable("wardid") Integer wardid){
        staffService.delete(id,wardid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


//    @DeleteMapping(path = "/{assemblyId}/{partId}")
//    public ResponseEntity deleteAssembly(@PathVariable("assemblyId") Integer assembly,@PathVariable("partId") Integer part)
//    {
//        assemblyService.delete(assembly,part)   ;
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("staff")
    public Collection<Staff> getAllStaff(){
        return staffService.findAllObjects();
    }










//
//    @GetMapping("staff_ward")
//    public Collection<Staff> getStaffByWard(@RequestParam(value="ward",required = false) Integer ward){
//
//        if(ward != null)
//            return service.findByWard(ward);
//
//        return service.findAllObjects();
//    }
//
//    @GetMapping("staff_person")
//    public Collection<Staff> getStaffByPerson(@RequestParam(value="person",required = false) Integer person){
//      if(person !=null)
//          return  service.findByPerson(person);
//      return service.findAllObjects();
//
//    }
//
//
//
//
//    @PostMapping("staff")
//    public ResponseEntity<Staff> add(@RequestBody Staff staff) {
//        return service.create(staff);
//    }
//
//
//
//    @PutMapping("staff")
//    public ResponseEntity<Staff> update(@RequestBody Staff staff) {
//        return service.update(staff);
//    }





}
