package com.example.demo.ctrls;

import com.example.demo.dtos.RoomDTO;
import com.example.demo.dtos.StaffDTO;
import com.example.demo.dtos.StaffModificationDTO;
import com.example.demo.entities.Room;
import com.example.demo.entities.Staff;
import com.example.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class RoomRestController {

    @Autowired
    private RoomService roomService;

    @GetMapping("room")
    public Collection<Room> getAllRooms(){
        return roomService.findAllObjects();
    }

    @GetMapping("room/{id}/{wid}")
    public ResponseEntity<RoomDTO>getRoomById(@PathVariable("id") Integer id,@PathVariable("wid") Integer wid){
        return ResponseEntity.ok(roomService.getRoomById(id,wid));
    }

    @PostMapping("room")
    public ResponseEntity<RoomDTO> insertRoom(@RequestBody RoomDTO roomDTO){
        return  ResponseEntity.ok(roomService.insert(roomDTO));
    }

    @PutMapping("room/{id}/{wid}")
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO,@PathVariable("id") Integer id,@PathVariable("wid") Integer wid)
    {
        return ResponseEntity.ok(roomService.update(roomDTO,id,wid));
    }

    @DeleteMapping("room/{id}/{wid}")
    public ResponseEntity deleteRoom(@PathVariable("id") Integer id,@PathVariable("wid") Integer wid){
        roomService.delete(id,wid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }





}
