package com.mindthehippo.budget.application.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class BudgetDTO {

    private String account;
    private List<ItemDTO> items;
    private List<GoalDTO> goals;

    private Map<Integer, Float> weekExpenses = new HashMap<>();
    private Map<Integer, Float> weekIncomes = new HashMap<>();
    
    private Map<String, Map<Integer, Float>> goalProgress = new HashMap<>();

    public BudgetDTO() {
        items = new ArrayList<>();
        goals = new ArrayList<>();
    }

    public BudgetDTO(String account, List<ItemDTO> items, List<GoalDTO> goals) {
        this.account = account;
        this.items = items;
        this.goals = goals;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public List<GoalDTO> getGoals() {
        return goals;
    }

    public void setGoals(List<GoalDTO> goals) {
        this.goals = goals;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    
    public Map<Integer, Float> getWeekExpenses() {
        return weekExpenses;
    }

    public void setWeekExpenses(Map<Integer, Float> weekExpenses) {
        this.weekExpenses = weekExpenses;
    }

    public Map<Integer, Float> getWeekIncomes() {
        return weekIncomes;
    }

    public void setWeekIncomes(Map<Integer, Float> weekIncomes) {
        this.weekIncomes = weekIncomes;
    }

    public Map<String, Map<Integer, Float>> getGoalProgress() {
        return goalProgress;
    }

    public void setGoalProgress(Map<String, Map<Integer, Float>> goalProgress) {
        this.goalProgress = goalProgress;
    }


}
