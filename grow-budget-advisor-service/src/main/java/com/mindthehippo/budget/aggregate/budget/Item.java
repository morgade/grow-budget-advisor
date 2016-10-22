package com.mindthehippo.budget.aggregate.budget;

import java.util.UUID;

/**
 * Budget item value object
 */
public class Item {

    private final UUID id;
    private final String text;
    private final Category category;
    private final float amount;

    public Item(UUID id, String text, Category category, float amount) {
        this.id = id;
        this.text = text;
        this.category = category;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public String getText() {
        return text;
    }
    
    public Category getCategory() {
        return category;
    }

}
