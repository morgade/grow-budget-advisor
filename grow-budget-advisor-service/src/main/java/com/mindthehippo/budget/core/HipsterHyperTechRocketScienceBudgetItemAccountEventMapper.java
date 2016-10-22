package com.mindthehippo.budget.core;

import com.mindthehippo.account.AccountEvent;
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
    public Item map(AccountEvent accountEvent) {
        //Do some hardcore rocket science mf intelligence here
        return null;
    }
    
}
