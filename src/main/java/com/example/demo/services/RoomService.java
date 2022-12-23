package com.example.demo.services;

import com.example.demo.dtos.RoomDTO;
import com.example.demo.dtos.StaffDTO;
import com.example.demo.entities.Room;
import com.example.demo.entities.Staff;

import java.util.Collection;

public interface RoomService {
    Collection<Room> findAllObjects();

    RoomDTO getRoomById(Integer id, Integer wid);

    RoomDTO insert(RoomDTO RoomDTO);

    RoomDTO update(RoomDTO roomDTO, Integer id, Integer wid);

    void delete(Integer id, Integer wid);
}
