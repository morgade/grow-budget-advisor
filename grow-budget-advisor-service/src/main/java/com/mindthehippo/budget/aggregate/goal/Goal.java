package com.mindthehippo.budget.aggregate.goal;

import java.util.UUID;

/**
 *
 */
public class Goal {
    private UUID id;
    private UUID account;
    private String text;
    private float amount;

    public Goal(UUID id, UUID account, String text, float amount) {
        this.id = id;
        this.account = account;
        this.text = text;
        this.amount = amount;
    }

}
