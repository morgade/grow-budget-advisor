package com.mindthehippo.budget.aggregate.budget;

import com.mindthehippo.budget.application.dto.BudgetDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Budget {

    private UUID account;
    private final List<Item> items;

    public Budget(UUID account) {
        this.account = account;
        items = new ArrayList<>();
    }

    public Budget(UUID account, List<Item> items) {
        this.account = account;
        this.items = items;
    }

    public UUID getAccount() {
        return account;
    }

    public List<Item> getItems() {
        return items;
    }
    
    // TODO: Spring Converter
    public static BudgetDTO convertToDTO(Budget budget) {
        BudgetDTO budgetDTO = new BudgetDTO();
        budgetDTO.setAccount(budget.getAccount().toString());
        for (Item item : budget.getItems()) {
            budgetDTO.getItems().add(Item.convertToDTO(item));
        }
        return budgetDTO;
    }

}
