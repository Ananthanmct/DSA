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

    // When delivery partner will click accept button then customer should get mail
    // Hey you delivery is assigned to this delivery partner he will be available in 10 mins
    // Delivery Partner -> Congratulations order is assigned to you deliver at this address in 10 mins
    @PutMapping("/order/accept/notify")
    public String acceptMail(@RequestBody RequestOrderDTO requestOrderDTO) throws Exception{
        mailService.notifyCustomerForOrderAssignment(requestOrderDTO);
        mailService.notifyDeliveryPartnerForOrderAcceptance(requestOrderDTO);
        return "Success";
    }
}
