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
        return Arrays.asList(new Category(UUID.fromString("64f8a0bc-9c83-4d5e-b59b-18991f049e1c"), "UTILITIES"),
                new Category(UUID.fromString("6e9bb33c-f8da-4942-981f-b955e102f9d9"), "PAYCHECK"),
                new Category(UUID.fromString("d06ed649-e38e-4667-bc4d-a56f1c05902d"), "TAXES"),
                new Category(UUID.fromString("4a5e2bbf-16e5-496c-b553-dfa8a0971716"), "CREDIT CARD"),
                new Category(UUID.fromString("74cf84ce-9d42-42af-b18b-7723d107fdc2"), "LOAN PAY")
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
