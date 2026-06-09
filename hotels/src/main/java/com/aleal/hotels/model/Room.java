package com.aleal.hotels.model;

import lombok.Data;

@Data
public class Room {
    private long roomId;
    private String roomName;
    private long hotelId;
    private String roomAvailable;
}
