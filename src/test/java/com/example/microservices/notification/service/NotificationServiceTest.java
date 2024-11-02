package com.example.microservices.notification.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.example.microservices.order.event.OrderPlacedEvent;

import jakarta.mail.internet.MimeMessage;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private JavaMailSender mockJavaMailSender;

    @Mock
    private MimeMessage mockMimeMessage;

    private NotificationService notificationService;

    @BeforeEach
    public void setUp() {
        // Mockito.when(mockJavaMailSender.createMimeMessage()).thenReturn(mockMimeMessage);
        notificationService = new NotificationService(mockJavaMailSender);
    }

    @Test
    public void testProcessOrderEventSucess() {
        OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent("OrderNumber",
                "Email",
                "FirstName",
                "LastName");
        notificationService.sendNotification(orderPlacedEvent);
        verify(mockJavaMailSender, times(1)).send(any(MimeMessagePreparator.class));
    }
}
