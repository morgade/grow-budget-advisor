package com.mindthehippo.budget.aggregate.budget;

import java.util.UUID;

/**
 * Budget item category value object
 */
public class Category {

    private UUID id;
    private String text;
    private boolean income;

    public Category() {
    }

    public Category(UUID id, String text, boolean income) {
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

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
