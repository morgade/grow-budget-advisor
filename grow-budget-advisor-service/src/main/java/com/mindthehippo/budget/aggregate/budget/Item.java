package com.mindthehippo.budget.aggregate.budget;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.Collections;
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

    private final Map<Integer, Float> weeklyActualExpenses = new HashMap<>();
    private final Map<Integer, Float> weeklyActualIncome = new HashMap<>();

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

    public Map<Integer, Float> getWeeklyActualIncome() {
        return Collections.unmodifiableMap(weeklyActualIncome);
    }

    public Map<Integer, Float> getWeeklyActualExpenses() {
        return Collections.unmodifiableMap(weeklyActualExpenses);
    }

    public float getActualExpensesByWeek(int week) {
        float f = 0;
        if (weeklyActualExpenses.containsKey(week)) {
            f = weeklyActualExpenses.get(week);
        }
        return f;
    }
    
    public float getActualIncomesByWeek(int week) {
        float f = 0;
        if (weeklyActualIncome.containsKey(week)) {
            f = weeklyActualIncome.get(week);
        }
        return f;
    }

    public void handleAccountEvent(Integer week, AccountEvent accountEvent) {
        // TODO: Store information about all events to help forge a proccess
        // to generate user tips into the dashboard
        float amountWeek = 0;
        switch (accountEvent.getType()) {
            case CREDIT:
                if (weeklyActualIncome.get(week) != null)  {
                    amountWeek = weeklyActualIncome.get(week);
                }
                amountWeek += accountEvent.getAmmount();
                weeklyActualIncome.put(week, amountWeek);
                break;
            case DEBIT: 
                if (weeklyActualExpenses.get(week) != null)  {
                    amountWeek = weeklyActualIncome.get(week);
                }
                amountWeek += accountEvent.getAmmount();
                weeklyActualExpenses.put(week, amountWeek);
                break;

        }
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
        return "Item{" + "id=" + id + ", text=" + text + ", category=" + category + ", amount=" + amount + ", weeklyActualExpenses=" + weeklyActualExpenses + '}';
    }

}
