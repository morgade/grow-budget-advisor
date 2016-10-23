package com.mindthehippo.budget.application.dto;

/**
 *
 * @author Lucas
 */
public class GoalDTO {

    private String text;
    private float amount;

    public GoalDTO() {
    }

    public GoalDTO(String text, float amount) {
        this.text = text;
        this.amount = amount;
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
