package com.mail.zepto.mail_api.requestbody;

import lombok.Data;

@Data
public class RequestOrderDTO {
    AppUser customer;
    AppUser deliveryPartner;
    ResponseBillDTO bill;
}
