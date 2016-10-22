package com.mindthehippo.budget.aggregate.budget;

import java.util.UUID;

/**
 * Budget item category value object
 */
public class Category {

    private UUID id;
    private String text;

    // TODO: definir mecanismo pra através da categoria, dar dicas e simular resultados. Um strategy ?
    public Category() {
    }

    public Category(UUID id, String text) {
        this.id = id;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
