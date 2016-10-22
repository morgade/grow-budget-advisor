package com.mindthehippo.budget.aggregate.budget;

import com.mindthehippo.budget.aggregate.goal.Goal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Marcelo
 */
public interface BudgetRepository {
    
    void armazenar(Budget budget);
    
    Budget get(UUID account);

    List<Goal> getGoals(UUID account);

    List<Item> getItens(UUID account);
    
}
