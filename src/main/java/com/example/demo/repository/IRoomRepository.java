package com.example.demo.repository;

import com.example.demo.entities.Room;
import com.example.demo.entities.RoomPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends JpaRepository<Room, RoomPK> {
}
