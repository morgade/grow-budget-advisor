package com.mindthehippo.budget.interfaces;

import com.mindthehippo.budget.application.BudgetApplicationService;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.GoalDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelo
 */
@RestController
public class BudgetController {

    @Autowired
    private BudgetApplicationService budgetAppService;

    @RequestMapping(path = "/budget/{accountId}")
    public BudgetDTO get(@PathVariable("accountId") UUID accountId, 
            @RequestParam(value="sw", required = false) Integer startRealizedWeek, 
            @RequestParam(value="ew", required = false) Integer endRealizedWeek) {
        // Accepting request without a period week for data for mocking purposes. Using default 1 to 10 as in 'dennis' account auto published events
        // TODO: Use a valid week/year absolute period in requests and make it mandatory
        return budgetAppService.get(accountId, startRealizedWeek==null?1:startRealizedWeek, endRealizedWeek==null?10:endRealizedWeek);
    }

    @RequestMapping(path = "/budget/{accountId}/item", method = RequestMethod.POST)
    public void addItem(@PathVariable("accountId") UUID accountId, @RequestBody ItemDTO item) {
        budgetAppService.store(accountId, item);
    }

    @RequestMapping(path = "/budget/{accountId}/goal", method = RequestMethod.POST)
    public void addGoal(@PathVariable("accountId") UUID accountId, @RequestBody GoalDTO goal) {
        budgetAppService.store(accountId, goal);
    }
    
}
