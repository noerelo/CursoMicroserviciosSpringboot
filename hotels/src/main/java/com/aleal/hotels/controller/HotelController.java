package com.aleal.hotels.controller;

import java.util.List;

import com.aleal.hotels.config.HotelsServiceConfiguration;
import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.PropertiesHotels;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;

@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;

	@Autowired
	private HotelsServiceConfiguration configHotels;
	
	@GetMapping("hotels")
	public List<Hotel> search(){
		return (List<Hotel>) this.service.search();	
	}

	@GetMapping("hotels/{hotelId}")
	//@CircuitBreaker(name = "searchHotelByIdSupportCB", fallbackMethod = "searchHotelByIdAlterntive")
	@Retry(name = "searchHotelByIdSupportRetry", fallbackMethod = "searchHotelByIdAlterntive")
	public HotelRooms searchHotelbyId(@PathVariable long hotelId){
		return this.service.searchHotelById(hotelId);
	}

	public HotelRooms searchHotelByIdAlterntive(long hotelId, Throwable thr){
		return this.service.searchHotelByIdWithoutRooms(hotelId);
	}

	@GetMapping("/hotels/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels propHotels = new PropertiesHotels(configHotels.getMsg(), configHotels.getBuildVersion(), configHotels.getMailDetails());
		return ow.writeValueAsString(propHotels);
	}

}
