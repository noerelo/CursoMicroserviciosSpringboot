package com.aleal.hotels.services.clients;

import com.aleal.hotels.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("rooms")
public interface RoomsFeignClient {

    @GetMapping("/rooms/{hotelId}")
    public List<Room> searchRoomByHotelId(@PathVariable Long hotelId);
}
