package com.mindthehippo.budget.core;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.application.BudgetItemAccountEventMapper;
import java.util.Optional;
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
        Optional<Item> i = budget.getItems().stream()
                .filter(item -> item.getText().equals(accountEvent.getDescription()))
                .reduce((t, u) -> { return t.getAmount() > u.getAmount()?t:u;});
        
        return i.orElse(budget.getItems().get(0));
    }
    
}
