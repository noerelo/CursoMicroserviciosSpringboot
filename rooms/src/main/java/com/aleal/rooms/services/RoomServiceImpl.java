package com.aleal.rooms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleal.rooms.dao.IRoomDao;
import com.aleal.rooms.model.Room;

@Service
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	private IRoomDao roomDao;

	@Override
	public List<Room> search() {
		return (List<Room>) roomDao.findAll();
	}

}
