package com.mindthehippo.budget.interfaces;

import com.mindthehippo.budget.application.BudgetApplicationService;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Marcelo
 */
//@RestController
public class BudgetController {

    @Autowired
    private BudgetApplicationService budgetAppService;

    @RequestMapping(path = "/budget/{accountId}")
    public BudgetDTO getItens(@PathVariable("accountId") UUID accountId) {
        return budgetAppService.get(accountId);
    }
}
