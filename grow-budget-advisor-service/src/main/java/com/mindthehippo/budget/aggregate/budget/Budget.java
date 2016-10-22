package com.mindthehippo.budget.aggregate.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Budget {

    private UUID account;
    private final List<Item> items;

    public Budget(UUID account) {
        this.account = account;
        items = new ArrayList<>();
    }

    public Budget(UUID account, List<Item> items) {
        this.account = account;
        this.items = items;
    }

    public UUID getAccount() {
        return account;
    }

    public List<Item> getItems() {
        return items;
    }

}
