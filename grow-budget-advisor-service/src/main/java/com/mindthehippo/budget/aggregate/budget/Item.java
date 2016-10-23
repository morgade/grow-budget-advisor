package com.mindthehippo.budget.aggregate.budget;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Budget item value object
 */
public class Item {

    private final UUID id;
    private final String text;
    private final Category category;
    private final float amount;

    private final Map<Integer, Float> weeklyActualAmount = new HashMap<>();

    public Item(UUID id, String text, Category category, float amount) {
        this.id = id;
        this.text = text;
        this.category = category;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public String getText() {
        return text;
    }

    public Category getCategory() {
        return category;
    }

    public Map<Integer, Float> getWeeklyActualAmount() {
        Map<Integer, Float> weeklyActualAmountClone = new HashMap<>();
        weeklyActualAmountClone.putAll(weeklyActualAmount);
        return weeklyActualAmountClone;
    }

    public float getActualByWeek(int week) {
        float f = 0;
        if (weeklyActualAmount.get(week) != null) {
            f = weeklyActualAmount.get(week);
        }
        return f;
    }

    public void addAccountEvent(Integer week, AccountEvent accountEvent) {
        float amountWeek = 0;
        if (weeklyActualAmount.get(week) != null) {
            amountWeek = weeklyActualAmount.get(week);
        }
        switch (accountEvent.getType()) {
            case CREDIT:
                amountWeek += accountEvent.getAmmount();
                break;
            case DEBIT:
                amountWeek -= accountEvent.getAmmount();
                break;

        }
        weeklyActualAmount.put(week, amountWeek);
    }

    // TODO: Spring Converter
    public static ItemDTO convertToDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId().toString());
        itemDTO.setAmount(item.getAmount());
        itemDTO.setCategory(item.getCategory());
        itemDTO.setText(item.getText());
        return itemDTO;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", text=" + text + ", category=" + category + ", amount=" + amount + ", weeklyActualAmount=" + weeklyActualAmount + '}';
    }

}
