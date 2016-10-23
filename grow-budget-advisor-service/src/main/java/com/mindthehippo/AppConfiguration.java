package com.mindthehippo;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.account.EventDispatcher;
import com.mindthehippo.account.EventSource;
import com.mindthehippo.account.EventType;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.event.BudgetSubscriber;
import com.mindthehippo.infrastructure.mock.MockService;
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

    @Autowired
    BudgetRepository budgetRepository;
    
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
//       String[] names = new String[]{"Paycheck", "Electricity", "Water/sewer"};
       UUID account = MockService.userAccounts.get("dennis");
        Budget budget = budgetRepository.get(account);
        Random random = new Random(System.currentTimeMillis()); 
        for (int i = 1; i <= 10; i++) {
            int week = i;
            budget.getItems().forEach( item -> {
                    eventDispatcher.dispatch(new AccountEvent(account,
                        item.getCategory().isIncome() ?  EventType.CREDIT : EventType.DEBIT, 
                        item.getText(),
                        item.getCategory().isIncome() ? item.getAmount() : ((random.nextFloat() * (random.nextInt(2)==0?1:-1) * 0.1f)+1f) *  item.getAmount(),
                        week)
                    );
            });
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
