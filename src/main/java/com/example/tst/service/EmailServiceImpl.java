package com.example.tst.service;

import com.example.tst.payload.EmailDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String email;
    @Override
    public void sendSimpleMail(EmailDetails details) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(email);
        mailMessage.setTo(details.getRecipient());
        mailMessage.setSubject(details.getSubject());
        mailMessage.setText(details.getMsgBody());
        try {
            javaMailSender.send(mailMessage);
        }catch (Exception e){
        }
    }
}
