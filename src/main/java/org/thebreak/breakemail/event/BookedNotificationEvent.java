package org.thebreak.breakemail.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
//import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BookedNotificationEvent {
    //@Id
    private String id;
    private String bookerEmail;
    private String bookerName;
    private int version;
}