package com.bms.notification_v1_api.service;

import com.bms.notification_v1_api.requestbody.TheatherRequestRB;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class TheatherMailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;


    public void notifyAdminForCreateTheatherRequest(TheatherRequestRB theatherRequestRB) throws MessagingException {
        Context context = new Context();
        context.setVariable("adminName", theatherRequestRB.getAdmin().getName());
        context.setVariable("theaterName", theatherRequestRB.getTheather().getName());
        context.setVariable("address", theatherRequestRB.getTheather().getAddress());
        context.setVariable("state", theatherRequestRB.getTheather().getState());
        context.setVariable("pincode", theatherRequestRB.getTheather().getPinCode());
        context.setVariable("ownerName", theatherRequestRB.getTheather().getOwner().getName());
        context.setVariable("ownerEmail", theatherRequestRB.getTheather().getOwner().getEmail());
        String htmlEmail = templateEngine.process("TheatherRequest", context);

        // MimeMessage ->
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
        mimeMessageHelper.setSubject("A new theater has registered and is awaiting your approval.");
        mimeMessageHelper.setTo(theatherRequestRB.getAdmin().getEmail());
        mimeMessageHelper.setText(htmlEmail, true);
        javaMailSender.send(message);
    }
}
