package com.mindthehippo.budget.aggregate.goal;

import com.mindthehippo.budget.application.dto.GoalDTO;
import java.util.UUID;

/**
 *
 */
public class Goal {
    private UUID id;
    private UUID account;
    private String text;
    private float amount;

    public Goal(UUID id, UUID account, String text, float amount) {
        this.id = id;
        this.account = account;
        this.text = text;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAccount() {
        return account;
    }

    public String getText() {
        return text;
    }

    public float getAmount() {
        return amount;
    }
    
        // TODO: Spring Converter
    public static GoalDTO convertToDTO(Goal goal) {
        GoalDTO goalDTO = new GoalDTO();
        goalDTO.setId(goal.getId().toString());
        goalDTO.setAmount(goal.getAmount());
        goalDTO.setText(goal.getText());
        return goalDTO;
    }

}
