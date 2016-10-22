/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.core;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.application.BudgetApplicationService;
import com.mindthehippo.budget.application.BudgetItemAccountEventMapper;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Novaes
 */
@Component
public class BudgetApplicationServiceImpl implements BudgetApplicationService {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    BudgetItemAccountEventMapper budgetItemAccountEventMapper;

    @Override
    public void store(UUID account, ItemDTO itemDTO) {
        Category category =  budgetRepository.getItemCategories().stream()
                .filter( c -> c.getId().toString().equals(itemDTO.getCategory()) )
                .findFirst().orElseThrow( () -> new IllegalArgumentException("Invalid Category"));
        
        Item item = new Item(UUID.fromString(itemDTO.getText()),
                itemDTO.getText(),
                category,
                itemDTO.getAmount());
        budgetRepository.store(account, item);
    }

    @Override
    public BudgetDTO get(UUID account) {
        Budget budget = budgetRepository.get(account);
        if (budget == null) {
            budget = new Budget(account);
            budgetRepository.store(budget);
            return modelMapper.map(budget, BudgetDTO.class);
        }
        return modelMapper.map(budgetRepository.get(account), BudgetDTO.class);
    }

    @Override
    public List<Category> getItemCagories() {
        return budgetRepository.getItemCategories();
    }

    @Override
    public void processAccountEvent(AccountEvent accountEvent) {
        System.out.println(accountEvent.getAccountId());
        Budget b = budgetRepository.get(accountEvent.getAccountId());
        System.out.println(b);
        Item item = budgetItemAccountEventMapper.map(b, accountEvent);
        item.addAccountEvent(accountEvent.getWeek(), accountEvent);
    }
}
