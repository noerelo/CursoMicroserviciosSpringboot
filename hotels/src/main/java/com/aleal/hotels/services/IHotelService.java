package com.aleal.hotels.services;

import java.util.List;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.model.HotelRooms;

public interface IHotelService {
	
	List<Hotel> search();
	HotelRooms searchHotelById(long hotelId);
	HotelRooms searchHotelByIdWithoutRooms(long hotelId);
}
