package com.mindthehippo.budget.application.dto;

/**
 *
 * @author Lucas
 */
public class GoalDTO {

    private String id;
    private String text;
    private float amount;

    public GoalDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
