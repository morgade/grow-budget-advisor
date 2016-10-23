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
    
    private Map<Integer,Float> weekRealized = new HashMap<>();
    
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

    public Map<Integer, Float> getWeekRealized() {
        return weekRealized;
    }

    public void setWeekRealized(Map<Integer, Float> weekRealized) {
        this.weekRealized = weekRealized;
    }
    
    
}
