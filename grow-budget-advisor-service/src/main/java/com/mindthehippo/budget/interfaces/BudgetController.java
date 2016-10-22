package com.mindthehippo.budget.interfaces;

import com.mindthehippo.budget.application.BudgetApplicationService;
import com.mindthehippo.budget.application.dto.Goal;
import com.mindthehippo.budget.application.dto.Item;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelo
 */
//@RestController
public class BudgetController {

    @Autowired
    private BudgetApplicationService budgetAppService;

    @RequestMapping(path = "/budget/{accountId}/item")
    public List<Item> getItens(@PathVariable("accountId") UUID accountId) {
        return budgetAppService.getItens(accountId);
    }

    @RequestMapping(path = "/budget/{accountId}/goal")
    public List<Goal> getGoals(@PathVariable("accountId") UUID accountId) {
        return budgetAppService.getGoals(accountId);
    }

}
