package com.aleal.rooms.dao;

import org.springframework.data.repository.CrudRepository;

import com.aleal.rooms.model.Room;

public interface IRoomDao extends CrudRepository<Room, Long>{

}
