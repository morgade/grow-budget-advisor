package com.mindthehippo.account;

import java.util.function.Consumer;

/**
 * Account service event source
 */
public interface EventSource {
    /**
     * Subscribe to listen all account events
     * @param subscriber 
     */
    void subscribe(Consumer<AccountEvent> subscriber);
}
