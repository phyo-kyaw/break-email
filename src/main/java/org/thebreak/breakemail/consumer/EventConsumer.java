package org.thebreak.breakemail.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.thebreak.breakemail.event.BookedNotificationEvent;

public interface EventConsumer {
    void consume(ConsumerRecord<String,Object> consumerRecord, Acknowledgment ack);

}
