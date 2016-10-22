/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.event;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.account.EventType;
import com.mindthehippo.budget.application.BudgetApplicationService;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lucas
 */
@Component
public class BudgetSubscriber implements Consumer<AccountEvent> {

    @Autowired
    BudgetApplicationService budgetAppService;
    
    
    @Override
    public void accept(AccountEvent event) {
        budgetAppService.processAccountEvent(event);
    }
    
}
