package com.mindthehippo.budget.interfaces;

import com.mindthehippo.budget.application.WonderfulTipService;
import com.mindthehippo.budget.application.dto.TipDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Must exists.
 * Temporarily, BudgetApplicationService is recovering tips.
 * 
 * @author Novaes
 */
@RestController
public class TipController {

    @Autowired
    private WonderfulTipService wonderfulTipService;

    @RequestMapping(path = "/tip/{accountId}")
    public List<TipDTO> get(@PathVariable("accountId") UUID accountId) {
        return wonderfulTipService.get(accountId);
    }
    
}
