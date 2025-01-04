package com.shopping.mailservice.Shopping_Mail_Service.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class ShopperMailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendCancelationMail(String email,
                                    String orderID){
        System.out.println("Inside Mail Service: Generating mime message");
        try{

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("CANCEL ORDER 123");
            mimeMessageHelper.setText(String.format("Canceling orderid %s", "Order1234"));
            javaMailSender.send(mimeMessage);
            System.out.println("Inside Mail Service: Mail sent");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
