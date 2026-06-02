package com.aleal.hotels.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class PropertiesHotels {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}
