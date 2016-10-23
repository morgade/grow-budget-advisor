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
    
    private final Map<Integer,Float> weeklyActualAmount = new HashMap<>();

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
    
    public float getActualByWeek(int week){
        return weeklyActualAmount.get(week);
    }
    
    public void addAccountEvent(Integer week, AccountEvent accountEvent){
        float amount = weeklyActualAmount.get(week);
        switch(accountEvent.getType()){
            case CREDIT:
                amount+=accountEvent.getAmmount();
                break;
            case DEBIT:
                amount-=accountEvent.getAmmount();
                break;
              
                    
        }
        weeklyActualAmount.put(week,amount);
    }

    public static ItemDTO convertToDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId().toString());
        itemDTO.setAmount(item.getAmount());
        itemDTO.setCategory(item.getCategory());
        itemDTO.setText(item.getText());
        return itemDTO;
    }

}
