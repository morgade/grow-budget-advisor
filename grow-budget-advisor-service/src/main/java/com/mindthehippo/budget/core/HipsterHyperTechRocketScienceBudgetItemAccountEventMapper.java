package com.mindthehippo.budget.core;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.application.BudgetItemAccountEventMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lucas
 */
@Component
public class HipsterHyperTechRocketScienceBudgetItemAccountEventMapper implements BudgetItemAccountEventMapper {

    @Override
    public Item map(Budget budget, AccountEvent accountEvent) {
        //Do some hardcore rocket science mf intelligence here
        System.out.println("Mapping "+budget.getAccount()+" "+accountEvent);
        Item i = budget.getItems().stream()
                .filter(item -> item.getText().equals(accountEvent.getDescription()))
                .reduce((t, u) -> { return t.getAmount() > u.getAmount()?t:u;}).get();
        if(i==null){
            return budget.getItems().get(0);
        }
        return i;
    }
    
}
