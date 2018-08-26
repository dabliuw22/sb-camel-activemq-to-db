
package com.leysoft.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.leysoft.service.inter.MailService;

@Service
public class MailServiceImp implements MailService {

    @Value(
            value = "${mail.from}")
    private String fromMail;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(String message, String subject, String... to) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromMail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setTo(to);
        mailSender.send(mailMessage);
    }
}
