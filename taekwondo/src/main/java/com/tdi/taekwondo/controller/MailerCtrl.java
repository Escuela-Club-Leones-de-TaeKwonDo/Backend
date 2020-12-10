package com.tdi.taekwondo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdi.taekwondo.service.EmailService;

@RestController
public class MailerCtrl {
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/sendmail")
    public String sendmail() {

        emailService.sendMail("kate@example.com", "Test Subject", "Test mail");

        return "emailsent";
    }
}
