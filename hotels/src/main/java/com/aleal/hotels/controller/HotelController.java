package com.aleal.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;

@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;
	
	
	@GetMapping("hotels")
	public List<Hotel> search(){
		return (List<Hotel>) this.service.search();	
	}

}
