package com.mindthehippo.budget.aggregate.budget;

/**
 * Budget item category value object
 */
public class Category {

    private String id;
    private String text;
    private boolean income;

    public Category() {
    }

    public Category(String id, String text, boolean income) {
        this.id = id;
        this.text = text;
        this.income = income;
    }

    public boolean isIncome() {
        return income;
    }

    public void setIncome(boolean income) {
        this.income = income;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
