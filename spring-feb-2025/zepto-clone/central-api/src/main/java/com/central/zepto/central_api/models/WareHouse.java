package com.central.zepto.central_api.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class WareHouse {
    UUID id;
    String name;
    String address;
    String email;
    int pincode;
    AppUser manager;
}
