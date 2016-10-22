/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.core;

import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.application.BudgetApplicationService;
import com.mindthehippo.budget.application.dto.GoalDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
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

    @Override
    public List<ItemDTO> getItens(UUID account) {
        return budgetRepository.getItens(account).stream().map(item -> modelMapper.map(item, ItemDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<GoalDTO> getGoals(UUID budget) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
