package com.mindthehippo.budget.aggregate.budget;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Budget {

    private UUID account;
    private List<Item> items;

    public Budget() {

    }

    public UUID getAccount() {
        return account;
    }

    public List<Item> getItems() {
        return items;
    }

}
