package com.mindthehippo.budget.aggregate.budget;

import com.mindthehippo.budget.aggregate.goal.Goal;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import static java.util.stream.Collectors.toList;

/**
 *
 */
public class Budget {
    
    private UUID account;
    private final List<Item> items;
    private final List<Goal> goals;
    
    public Budget(UUID account) {
        this.account = account;
        items = new ArrayList<>();
        goals = new ArrayList<>();
    }
    
    public Budget(UUID account, List<Item> items, List<Goal> goals) {
        this.account = account;
        this.items = items;
        this.goals = goals;
    }
    
    public Map<Integer, Float> getWeekProfit() {
        Map<Integer, Float> weeklyProfit = new HashMap<>();
        float plannedBudget = getPlannedBudget();
        for (int i = 1; i < 54; i++) {
            
            float totalRealized = 0;
            float profit = 0;
            final int index = i;
            totalRealized = getItems().stream().map(item -> item.getActualByWeek(index)).reduce(Float::sum).get();
            profit = totalRealized - plannedBudget;
            weeklyProfit.put(index, profit);
            plannedBudget-=totalRealized;
        }
        return weeklyProfit;
    }
    
    public float getActualBudget(int week) {
        float f = getItems().stream().map(item -> item.getActualByWeek(week)).reduce(Float::sum).get();
        return f;
    }
    
    public UUID getAccount() {
        return account;
    }
    
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
    
    public List<Goal> getGoals() {
        return Collections.unmodifiableList(goals);
    }
    
    public void addGoal(Goal g) {
        this.goals.add(g);
    }
    
    public void addItem(Item item) {
        this.items.add(item);
    }
    
    public float getPlannedBudget() {
        float f = getItems().stream().map(Item::getAmount).reduce(Float::sum).get();
        return f;
    }

    // TODO: Spring Converter
    public static BudgetDTO convertToDTO(Budget budget) {
        BudgetDTO budgetDTO = new BudgetDTO();
        budgetDTO.setAccount(budget.getAccount().toString());
        budgetDTO.getItems().addAll(
                budget.getItems().stream().map(Item::convertToDTO).collect(toList())
        );
        budgetDTO.getGoals().addAll(
                budget.getGoals().stream().map(Goal::convertToDTO).collect(toList())
        );
        
        budgetDTO.setWeekProfit(budget.getWeekProfit());
        budgetDTO.setPlannedBudget(budget.getPlannedBudget());
        return budgetDTO;
    }
    
}
