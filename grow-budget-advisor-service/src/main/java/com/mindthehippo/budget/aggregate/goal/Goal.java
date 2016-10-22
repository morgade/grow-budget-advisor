package com.mindthehippo.budget.aggregate.goal;

import java.util.UUID;

/**
 *
 */
public class Goal {
    private UUID id;
    private UUID account;
    private String text;
    private Category category;
    private float amount;
}
