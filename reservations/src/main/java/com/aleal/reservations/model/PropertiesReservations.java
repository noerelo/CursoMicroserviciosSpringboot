package com.aleal.reservations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class PropertiesReservations {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}
