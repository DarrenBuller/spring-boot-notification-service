package com.example.microservices.notification.service;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import jakarta.mail.internet.MimeMessage;

@Configuration
public class MockMailConfiguration {

    private JavaMailSender javaMailSender;

    private MimeMessage mimeMessage;

    @Bean
    JavaMailSender mockMailSender() {
        mimeMessage = Mockito.mock(MimeMessage.class);
        javaMailSender = Mockito.mock(JavaMailSender.class);
        Mockito.when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        return javaMailSender;
    }
}
