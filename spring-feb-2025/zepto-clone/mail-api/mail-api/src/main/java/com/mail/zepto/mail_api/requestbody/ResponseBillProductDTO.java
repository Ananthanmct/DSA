package com.mail.zepto.mail_api.requestbody;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseBillProductDTO {
    UUID productId;
    String productName;
    int quantity;
    double amount;
}

