/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.application;

import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.UUID;

/**
 *
 * @author Lucas
 */
public interface BudgetApplicationService {
    
    
    public BudgetDTO get(UUID account);
    
    void store(UUID account, ItemDTO itemDTO);
}
