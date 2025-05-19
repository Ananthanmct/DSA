package com.tmdb.notification_api.service;

import com.tmdb.notification_api.model.Organization;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Properties;

@Service
public class OrgService {

    public void notifyAdminForOrgCreation(Organization organization) throws Exception {

        // Configure JavaMailSender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("accioshoppingwebsite@gmail.com");
        mailSender.setPassword("relcfdwhahhcvokv");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Build Email Content
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(organization.getAdminEmail());
        helper.setSubject("Congrats!! Account Created Successfully");

        // Thymeleaf context
        Context context = new Context();
        context.setVariable("platformName", "AccioJob");
        context.setVariable("adminName", organization.getAdminName());
        context.setVariable("registeredName", organization.getRegisteredName());
        context.setVariable("websiteUrl", organization.getWebsiteUrl());
        context.setVariable("companySize", organization.getCompanySize());
        context.setVariable("adminEmail", organization.getAdminEmail());
        context.setVariable("address", organization.getAddress());
        context.setVariable("createdAt", organization.getCreatedAt());

        // Setup Thymeleaf template engine
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/"); // Make sure this folder exists in resources
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        String htmlContent = templateEngine.process("org-create-notification", context);
        helper.setText(htmlContent, true); // Enable HTML

        // Send mail
        mailSender.send(mimeMessage);
    }
}