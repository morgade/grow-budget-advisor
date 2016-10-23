package com.mindthehippo.budget.aggregate.budget;

import java.util.UUID;

/**
 *
 * @author Novaes
 */
public class Tip {

    private final UUID id;
    private final String text;
    private final String kind;

    public Tip(UUID id, String text, String kind) {
        this.id = id;
        this.text = text;
        this.kind = kind;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getKind() {
        return kind;
    }

}
