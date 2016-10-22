
package com.mindthehippo.account;

import java.util.UUID;

/**
 *
 */
public class AccountEvent {
    private final UUID id;
    private final EventType type;
    private final String description;
    private final float ammount;

    public AccountEvent(UUID id, EventType type, String description, float ammount) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.ammount = ammount;
    }

    public UUID getId() {
        return id;
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
