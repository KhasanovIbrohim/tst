package com.example.tst.service;


import com.example.tst.payload.EmailDetails;

public interface EmailService {
    void sendSimpleMail(EmailDetails details);
}
