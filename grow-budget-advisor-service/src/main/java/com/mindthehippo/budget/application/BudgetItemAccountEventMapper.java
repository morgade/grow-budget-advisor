package com.mindthehippo.budget.application;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.Item;

/**
 *
 * @author Lucas
 */
public interface BudgetItemAccountEventMapper {

    //Using truly advanced artificial intelligence and complex heuristics should
    //find which budget item matches with the account event informed 
    Item map(Budget budget, AccountEvent accountEvent);

}
