package org.thebreak.breakemail.handler;

import org.thebreak.breakemail.event.BookedNotificationEvent;

public interface EventHandler {
    void on(BookedNotificationEvent event);
}
