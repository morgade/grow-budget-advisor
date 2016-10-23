package com.mindthehippo;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.account.EventDispatcher;
import com.mindthehippo.account.EventSource;
import com.mindthehippo.account.EventType;
import com.mindthehippo.budget.event.BudgetSubscriber;
import com.mindthehippo.infrastructure.mock.MockService;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 *
 * @author Lucas
 */
@Configuration
public class AppConfiguration {

    @Autowired
    EventSource eventSource;

    @Autowired
    EventDispatcher eventDispatcher;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
       String[] names = new String[]{"Paycheck", "Electricity", "Water/sewer"};
        int currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int weekOffset = random.nextInt(10);
            int nameIndex = random.nextInt(3);
            eventDispatcher.dispatch(new AccountEvent(UUID.fromString("7f713be0-b7ed-4aba-b69c-972ee3203253"),
                     nameIndex > 0 ? EventType.DEBIT : EventType.CREDIT, names[nameIndex],
                     nameIndex > 0 ? random.nextInt(100): random.nextInt(5000), currentWeek - weekOffset));
        }
    }
    
    //In case Budget is isolated as a microservice, this definition should move to the specific service config
    @Bean
    public BudgetSubscriber createBudgetSubscriber() {
        //Should locate the AccountEventManager from the account service
        //Using a mocked event manager as the account service isnt the main feature
        BudgetSubscriber subscriber = new BudgetSubscriber();
        eventSource.subscribe(subscriber);
        
        return subscriber;
    }

    @Bean
    public MockService createMockService() {
        return new MockService();
    }
}
