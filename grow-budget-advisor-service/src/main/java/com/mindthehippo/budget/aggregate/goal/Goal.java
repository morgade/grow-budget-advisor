package com.mindthehippo.budget.aggregate.goal;

import com.mindthehippo.budget.application.dto.GoalDTO;
import java.util.UUID;

/**
 *
 */
public class Goal {

    private final UUID id;
    private final UUID account;
    private final String text;
    private final float amount;
    private final int initialWeek;

    public Goal(UUID id, UUID account, String text, float amount, int initialWeek) {
        this.id = id;
        this.account = account;
        this.text = text;
        this.amount = amount;
        this.initialWeek = initialWeek;
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

    public int getInitialWeek() {
        return initialWeek;
    }

    // TODO: Spring Converter
    public static GoalDTO convertToDTO(Goal goal) {
        GoalDTO goalDTO = new GoalDTO();
        goalDTO.setId(goal.getId().toString());
        goalDTO.setAmount(goal.getAmount());
        goalDTO.setText(goal.getText());
        goalDTO.setInitialWeek(goal.getInitialWeek());
        return goalDTO;
    }

}
