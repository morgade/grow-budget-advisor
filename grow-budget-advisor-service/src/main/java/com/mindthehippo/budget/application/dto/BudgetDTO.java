package com.mindthehippo.budget.application.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class BudgetDTO {

    private UUID account;
    private List<ItemDTO> items;

    public BudgetDTO() {
        items = new ArrayList<>();
    }

    public BudgetDTO(UUID account, List<ItemDTO> items) {
        this.account = account;
        this.items = items;
    }

    public UUID getAccount() {
        return account;
    }

    public void setAccount(UUID account) {
        this.account = account;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}