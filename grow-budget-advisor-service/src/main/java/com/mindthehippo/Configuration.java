/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo;

import com.mindthehippo.account.EventSource;
import com.mindthehippo.budget.event.BudgetSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Lucas
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    EventSource eventSource;
        
    //In case Budget is isolated as a microservice, this definition should move to the specific service config
    @Bean
    public BudgetSubscriber createBudgetSubscriber() {
        //Should locate the AccountEventManager from the account service
        //Using a mocked event manager as the account service isnt the main feature
        BudgetSubscriber subscriber = new BudgetSubscriber();
        eventSource.subscribe(subscriber);
        return subscriber;
    }
}
