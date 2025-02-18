package com.central.zepto.central_api.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class WareHouseProducts {
    UUID id;
    UUID wid;
    UUID pid;
    int discount;
    int totalQuantity;
}
