package com.mail.zepto.mail_api.service;

import com.mail.zepto.mail_api.requestbody.RequestOrderDTO;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendOrderNotifcationToDeliveryPartner(RequestOrderDTO orderDetails) throws Exception{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
        mimeMessageHelper.setTo(orderDetails.getDeliveryPartner().getEmail());
        mimeMessageHelper.setSubject("A new order has been placed. Please review the detail");


        Context context = new Context();
        context.setVariable("deliveryPartnerName", orderDetails.getDeliveryPartner().getName());
        context.setVariable("customerName", orderDetails.getCustomer().getName());
        context.setVariable("customerPhone", orderDetails.getCustomer().getPhoneNumber());
        context.setVariable("customerAddress", orderDetails.getCustomer().getAddress());
        context.setVariable("orderId", orderDetails.getBill().getOrderId());
        context.setVariable("productList", orderDetails.getBill().getProducts());
        context.setVariable("totalBill", orderDetails.getBill().getTotalBillPayed());


        String htmlTemplate = templateEngine.process("order-notification", context);
        mimeMessageHelper.setText(htmlTemplate, true);
        mailSender.send(message);
    }
}
