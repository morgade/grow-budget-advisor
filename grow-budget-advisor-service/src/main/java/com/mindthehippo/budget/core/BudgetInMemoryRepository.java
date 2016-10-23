package com.mindthehippo.budget.core;

import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.budget.Goal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *  Persists Budget data in Memory.
 *  TODO: NOSQL DB persistence ???
 * 
 * @author Novaes
 */
@Component
public class BudgetInMemoryRepository implements BudgetRepository {
    public static final String CATEGORY_PAYCHECK = "PAYCHECK";
    public static final String CATEGORY_UTILITIES = "UTILITIES";
    public static final String CATEGORY_TAXES = "TAXES";
    public static final String CATEGORY_LOAN = "LOAN";
    
    Map<UUID, Budget> budgets = new HashMap<>();

    @Override
    public List<Item> getItens(UUID account) {
        return budgets.get(account).getItems();
    }

    @Override
    public List<Category> getItemCategories() {
        return Arrays.asList(new Category("UTILITIES", "Utilities", false),
                new Category("PAYCHECK", "Paycheck", true),
                new Category("TAXES", "Taxes", false),
                new Category("CREDIT_CARD", "Credit Card", false),
                new Category("LOAN", "Loan Installment", false)
        );

    }

    @Override
    public List<Goal> getGoals(UUID account) {
        return budgets.get(account).getGoals();
    }

    @Override
    public void store(Budget budget) {
        budgets.put(budget.getAccount(), budget);
    }

    @Override
    public void store(UUID account, Item item) {
        budgets.get(account).addItem(item);
    }

    @Override
    public void store(UUID account, Goal goal) {
        budgets.get(account).addGoal(goal);
    }

    @Override
    public Budget get(UUID account) {
        return budgets.get(account);
    }

}
