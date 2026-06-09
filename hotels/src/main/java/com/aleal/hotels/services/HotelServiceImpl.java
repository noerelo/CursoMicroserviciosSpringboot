package com.aleal.hotels.services;

import java.util.*;

import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.Room;
import com.aleal.hotels.services.clients.RoomsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleal.hotels.dao.IHotelDao;
import com.aleal.hotels.model.Hotel;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;

	@Autowired
	private RestTemplate clienteRest;

	@Autowired
	private RoomsFeignClient roomsFeignClient;

	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}

	@Override
	public HotelRooms searchHotelById(long hotelId) {
		HotelRooms response = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);

//		Map<String, Long> pathVariable = new HashMap<>();
//		pathVariable.put("id", hotelId);
//		List<Room> rooms = Arrays.asList(clienteRest.getForObject("http://localhost:8081/roomsByHotelId/{id}", Room[].class, pathVariable));
		List<Room> rooms = roomsFeignClient.searchRoomByHotelId(hotelId);
		response.setHotelId(hotel.get().getHotelId());
		response.setHotelName(hotel.get().getHotelName());
		response.setHotelAddress(hotel.get().getHotelAddress());
		response.setRooms(rooms);
		return response;
	}

	@Override
	public HotelRooms searchHotelByIdWithoutRooms(long hotelId) {
		HotelRooms response = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		response.setHotelId(hotel.get().getHotelId());
		response.setHotelName(hotel.get().getHotelName());
		response.setHotelAddress(hotel.get().getHotelAddress());
		response.setRooms(null);
		return response;
	}
}
