package com.mindthehippo.budget.aggregate.budget;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Marcelo
 */
public interface BudgetRepository {
    
    void store(Budget budget);
    
    void store(UUID account, Item item);
    
    void store(UUID account, Goal goal);
    
    Budget get(UUID account);
    
    List<Category> getItemCategories();

    List<Goal> getGoals(UUID account);

    List<Item> getItens(UUID account);
    
}


