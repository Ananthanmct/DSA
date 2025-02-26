package com.mail.zepto.mail_api.controller;

import com.mail.zepto.mail_api.requestbody.RequestOrderDTO;
import com.mail.zepto.mail_api.requestbody.ResponseBillDTO;
import com.mail.zepto.mail_api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail/delivery-partner")
public class DeliveryPartnerController {

    @Autowired
    MailService mailService;


    @PutMapping("/order/notify")
    public String orderNotification(@RequestBody RequestOrderDTO requestOrderDTO) throws Exception{
        mailService.sendOrderNotifcationToDeliveryPartner(requestOrderDTO);
        return "Success";
    }
}
