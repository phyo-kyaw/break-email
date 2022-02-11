package org.thebreak.breakemail.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.thebreak.breakemail.event.BookedNotificationEvent;
import org.thebreak.breakemail.handler.EventHandler;

@Service
public class BookedNotificationEventConsumer implements EventConsumer {
    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics = "email", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(@Payload BookedNotificationEvent event, Acknowledgment ack) {

        this.eventHandler.on(event);
        ack.acknowledge();
    }

}
