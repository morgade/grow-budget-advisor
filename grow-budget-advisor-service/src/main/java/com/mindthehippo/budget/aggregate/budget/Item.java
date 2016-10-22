package com.mindthehippo.budget.aggregate.budget;

import java.util.UUID;

/**
 * Budget item value object
 */
public class Item {

    private final UUID id;
    private final Category category;
    private final float amount;

    public Item(UUID id, Category category, float amount) {
        this.id = id;
        this.category = category;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

}
