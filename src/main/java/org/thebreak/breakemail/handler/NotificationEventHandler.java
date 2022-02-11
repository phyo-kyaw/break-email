package org.thebreak.breakemail.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thebreak.breakemail.event.BookedNotificationEvent;
import org.thebreak.breakemail.service.EmailService;

@Service
public class NotificationEventHandler implements EventHandler {
    @Autowired
    private EmailService emailService;

    @Override
    public void on(BookedNotificationEvent event) {
        emailService.sendNotificationEmail(event.getBookerEmail(), event.getBookerName());

    }

}
