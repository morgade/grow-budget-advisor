/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.aggregate.budget;

import java.util.UUID;

/**
 *
 * @author Novaes
 */
public class Tip {

    private final UUID id;
    private final String text;

    public Tip(UUID id, String text) {
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
