package com.mindthehippo.account;

import java.util.function.Consumer;

/**
 *
 */
public interface EventSource {
    
    void subscribe(Consumer<AccountEvent> subscriber);
    
}
