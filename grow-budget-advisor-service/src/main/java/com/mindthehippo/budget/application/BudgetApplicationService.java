/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.application;

import com.mindthehippo.budget.application.dto.Goal;
import com.mindthehippo.budget.application.dto.Item;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Lucas
 */
public interface BudgetApplicationService {
    
    
    public List<Item> getItens(UUID budget);
    
    public List<Goal> getGoals(UUID budget);
}
