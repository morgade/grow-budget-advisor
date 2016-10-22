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
public class ItemDTO {

    private float amount;
    private String category;

    public ItemDTO() {
    }

    public ItemDTO(float amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
