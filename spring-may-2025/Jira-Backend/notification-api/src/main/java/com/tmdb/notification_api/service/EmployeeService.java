package com.tmdb.notification_api.service;

import com.tmdb.notification_api.model.Employee;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Properties;

@Service
public class EmployeeService {
    public void sendInvitationMail(Employee employee) throws Exception{
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
        helper.setTo(employee.getEmail());
        helper.setSubject("You're Invited to Join " + employee.getOrganization().getRegisteredName());

        // Thymeleaf context
        Context context = new Context();
        context.setVariable("organizationName", employee.getOrganization().getRegisteredName());
        context.setVariable("firstName", employee.getFirstName());
        context.setVariable("lastName", employee.getLastName());
        context.setVariable("acceptUrl", "https://www.google.com/");
        context.setVariable("rejectUrl", "https://www.google.com/");
        context.setVariable("year", "2025");


        // Setup Thymeleaf template engine
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/"); // Make sure this folder exists in resources
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        String htmlContent = templateEngine.process("invite-employee-notification", context);
        helper.setText(htmlContent, true); // Enable HTML

        // Send mail
        mailSender.send(mimeMessage);
    }
}
