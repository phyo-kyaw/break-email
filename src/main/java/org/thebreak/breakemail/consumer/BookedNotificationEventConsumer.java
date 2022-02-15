package org.thebreak.breakemail.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = {"appt-email-events"}, groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(ConsumerRecord<Integer,String> consumerRecord, Acknowledgment ack) {

        BookedNotificationEvent event = null;

        try {
            event = objectMapper.readValue(consumerRecord.value(), BookedNotificationEvent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        this.eventHandler.on(event);
        ack.acknowledge();
    }


    @KafkaListener(topics = {"email-evts"}, groupId = "${spring.kafka.consumer.group-id}")
    //@Override
    public void consumeX(@Payload BookedNotificationEvent event, Acknowledgment ack) {

        this.eventHandler.on(event);
        ack.acknowledge();
    }
}
