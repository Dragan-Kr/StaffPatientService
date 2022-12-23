package com.example.demo.impl;

import com.example.demo.dtos.RoomDTO;
import com.example.demo.dtos.StaffDTO;
import com.example.demo.dtos.StaffModificationDTO;
import com.example.demo.entities.Room;
import com.example.demo.entities.RoomPK;
import com.example.demo.entities.Staff;
import com.example.demo.entities.StaffPK;
import com.example.demo.repository.IRoomRepository;
import com.example.demo.services.RoomService;
import com.example.demo.services.WardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoomServiceImplem implements RoomService {

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private WardService wardService;


    @Override
    public Collection<Room> findAllObjects() {
        return roomRepository.findAll();
    }

    @Override
    public RoomDTO getRoomById(Integer id, Integer wid) {
        Room foundRoom = roomRepository.findById(new RoomPK(id,wid)).get();
        foundRoom.setId(id);
        foundRoom.setWid((wardService.getWardById(foundRoom.getWid())).getId());
        RoomDTO mappedRoom = new RoomDTO(foundRoom.getId(),foundRoom.getWid(),foundRoom.getBedNumber(),foundRoom.getrGender());
        return mappedRoom;
    }



    @Override
    public RoomDTO insert(RoomDTO room) {
        Room newRoom = new Room();
        newRoom.setId(room.getId());
        newRoom.setWid(room.getWid());
        newRoom.setrGender(room.getrGender());
        newRoom.setBedNumber(room.getBedNumber());
        newRoom = roomRepository.save(newRoom);
        RoomDTO mappedRoom = new RoomDTO(newRoom.getId(), newRoom.getWid(), newRoom.getBedNumber(), newRoom.getrGender());
        return mappedRoom;
    }

    @Override
    public RoomDTO update(RoomDTO room, Integer id, Integer wid) {
       Room updatedRoom = roomRepository.findById(new RoomPK(id,wid)).map(oldRoom ->{
           oldRoom.setBedNumber(room.getBedNumber());
           oldRoom.setrGender(room.getrGender());
           return  roomRepository.save(oldRoom);
       }).get();

       updatedRoom.setId(id);
       updatedRoom.setWard(wardService.getWardById(updatedRoom.getWid()));
       RoomDTO mappedRoom = new RoomDTO(updatedRoom.getId(), updatedRoom.getWid(), updatedRoom.getBedNumber(), updatedRoom.getrGender());
       return  mappedRoom;
    }

    @Override
    public void delete(Integer id, Integer wid) {
        roomRepository.deleteById(new RoomPK(id,wid));
    }

}
