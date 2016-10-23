
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
    private final int week;

    public AccountEvent(UUID accountId, EventType type, String description, float ammount, int week) {
        this.accountId = accountId;
        this.type = type;
        this.description = description;
        this.ammount = ammount;
        this.week = week;
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

    public int getWeek() {
        return week;
    }

    @Override
    public String toString() {
        return "AccountEvent{" + "accountId=" + accountId + ", type=" + type + ", description=" + description + ", ammount=" + ammount + ", week=" + week + '}';
    }
    
    
}
