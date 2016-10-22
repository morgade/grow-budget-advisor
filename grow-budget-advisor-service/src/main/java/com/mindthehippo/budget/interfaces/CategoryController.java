package com.mindthehippo.budget.interfaces;

import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.application.BudgetApplicationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */
@RestController
public class CategoryController {

    @Autowired
    private BudgetApplicationService budgetAppService;

    @RequestMapping(path = "/category")
    public List<Category> getAll() {
        return budgetAppService.getItemCagories();
    }
}
