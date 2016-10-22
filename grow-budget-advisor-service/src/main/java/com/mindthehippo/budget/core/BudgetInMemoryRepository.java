/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.core;

import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.goal.Goal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *
 * @author Novaes
 */
@Component
public class BudgetInMemoryRepository implements BudgetRepository {

    List<Budget> budgets = new ArrayList<>();

    @Override
    public List<Item> getItens(UUID account) {
        return budgets.stream()
                .filter(b -> b.getAccount().equals(account))
                .findFirst().get().getItems();
    }

    @Override
    public List<Goal> getGoals(UUID budget) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void armazenar(Budget budget) {
        budgets.add(budget);
    }

    @Override
    public Budget get(UUID account) {
        return budgets.stream().
                filter(b -> b.getAccount().equals(account)).
                findFirst().get();
    }

}
