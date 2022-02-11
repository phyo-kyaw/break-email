package org.thebreak.breakemail.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BookedNotificationEvent {
    private String bookerEmail;
    private String bookerName;
    private int version;
}