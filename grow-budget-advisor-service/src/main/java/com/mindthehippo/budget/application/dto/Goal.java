/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.application.dto;

/**
 *
 * @author Lucas
 */
public class Goal {

    private String text;
    private String category;
    private float amount;

    public Goal() {
    }

    public Goal(String text, String category, float amount) {
        this.text = text;
        this.category = category;
        this.amount = amount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
