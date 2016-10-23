package com.mindthehippo.budget.core;

import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.goal.Goal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *
 * @author Novaes
 */
@Component
public class BudgetInMemoryRepository implements BudgetRepository {

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
                new Category("LOAN", "Loan Payment", false)
        );

    }

    @Override
    public List<Goal> getGoals(UUID budget) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void store(Budget budget) {
        budgets.put(budget.getAccount(), budget);
    }

    @Override
    public void store(UUID account, Item item) {
        budgets.get(account).getItems().add(item);
    }

    @Override
    public Budget get(UUID account) {
        return budgets.get(account);
    }

}
