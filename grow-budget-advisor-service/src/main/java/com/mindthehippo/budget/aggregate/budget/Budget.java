package com.mindthehippo.budget.aggregate.budget;

import com.mindthehippo.budget.application.dto.BudgetDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import static java.util.stream.Collectors.toList;

/**
 * 
 * 
 */
public class Budget {
    
    private final UUID account;
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
    
    public Map<Integer, Float> getGoalProgress(Goal goal, int endWeek) {
        Map<Integer, Float> goalProgress = new HashMap<>();
        Map<Integer, Float> expenses = getWeeklyExpenses(goal.getInitialWeek(), endWeek);
        Map<Integer, Float> incomes = getWeeklyIncomes(goal.getInitialWeek(), endWeek);
        for (int week = goal.getInitialWeek(); week < endWeek; week++) {
            goalProgress.put(week, goalProgress.getOrDefault(week-1, 0f) + incomes.getOrDefault(week, 0f) - expenses.getOrDefault(week, 0f));
        }
        return goalProgress;
    }
    
    public float getActualExpenses(int week) {
        return getItems().stream().map(item -> item.getActualExpensesByWeek(week)).reduce(Float::sum).get();
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
    
    private Map<Integer, Float> getWeeklyExpenses(int startWeek, int endWeek) {
        Map<Integer, Float> r = new HashMap<>();
        for (int i = startWeek; i <=endWeek; i++) {
            final int index = i;
            float expenses = getItems().stream().filter(it->!it.getCategory().isIncome()).map(item -> item.getActualExpensesByWeek(index)).reduce(Float::sum).get();
            r.put(index, expenses);
        }
        return r;

    }

    private Map<Integer, Float> getWeeklyIncomes(int startWeek, int endWeek) {
        Map<Integer, Float> r = new HashMap<>();
        for (int i = startWeek; i <=endWeek; i++) {
            final int index = i;
            float income = getItems().stream().filter(it->it.getCategory().isIncome()).map(item -> item.getActualIncomesByWeek(index)).reduce(Float::sum).get();
            r.put(index, income);
        }
        return r;

    }

    // TODO: Spring Converter
    public static BudgetDTO convertToDTO(Budget budget, int startWeek, int endWeek) {
        BudgetDTO budgetDTO = new BudgetDTO();
        budgetDTO.setAccount(budget.getAccount().toString());
        budgetDTO.getItems().addAll(
                budget.getItems().stream().map(Item::convertToDTO).collect(toList())
        );
        budgetDTO.getGoals().addAll(
                budget.getGoals().stream().map(Goal::convertToDTO).collect(toList())
        );
        
        Map<String, Map<Integer, Float>> goalProgresses = new HashMap<>();
        budget.getGoals().forEach( g -> {
            goalProgresses.put(g.getId().toString(), budget.getGoalProgress(g, endWeek));
        });
        
        budgetDTO.setGoalProgress(goalProgresses);
        budgetDTO.setWeekExpenses( budget.getWeeklyExpenses(startWeek, endWeek) );
        budgetDTO.setWeekIncomes(budget.getWeeklyIncomes(startWeek, endWeek) );
        return budgetDTO;
    }
    
}
