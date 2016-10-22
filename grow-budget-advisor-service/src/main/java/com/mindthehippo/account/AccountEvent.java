
package com.mindthehippo.account;

import java.util.UUID;

/**
 *
 */
public class AccountEvent {
    private final UUID accountId;
    private final EventType type;
    private final String description;
    private final float ammount;

    public AccountEvent(UUID accountId, EventType type, String description, float ammount) {
        this.accountId = accountId;
        this.type = type;
        this.description = description;
        this.ammount = ammount;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public EventType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public float getAmmount() {
        return ammount;
    }
    
    
}
