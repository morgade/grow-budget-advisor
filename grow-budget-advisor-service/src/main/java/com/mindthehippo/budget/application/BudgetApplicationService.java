/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.application;

import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Lucas
 */
public interface BudgetApplicationService {
    
    
    public BudgetDTO get(UUID account);
    
    public List<Category> getItemCagories();
    
    void store(UUID account, ItemDTO itemDTO);
}
