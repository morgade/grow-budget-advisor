package com.mindthehippo.account.core;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.account.EventDispatcher;
import com.mindthehippo.account.EventSource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

/**
 * A mocked event manager directly dispatch items to an in memory subscriber
 * @author Lucas
 */
@Component
public class MockedAccountEventManager implements EventSource, EventDispatcher {

    
    private final List<Consumer<AccountEvent>> subscribers = new ArrayList();
    
    @Override
    public void subscribe(Consumer<AccountEvent> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void dispatch(AccountEvent event) {
        subscribers.forEach(t -> t.accept(event));
    }
    
}
