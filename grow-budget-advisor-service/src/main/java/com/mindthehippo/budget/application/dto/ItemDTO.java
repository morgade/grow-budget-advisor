/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.application.dto;

import com.mindthehippo.budget.aggregate.budget.Category;

/**
 *
 * @author Lucas
 */
public class ItemDTO {

    private String id;
    private float amount;
    private String text;
    private Category category;

    public ItemDTO() {
    }

    public ItemDTO(String id, float amount, String text, Category category) {
        this.id = id;
        this.amount = amount;
        this.text = text;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
