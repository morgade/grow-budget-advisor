package com.mindthehippo.budget.core;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.goal.Goal;
import com.mindthehippo.budget.application.BudgetApplicationService;
import com.mindthehippo.budget.application.BudgetItemAccountEventMapper;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.GoalDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implements budget operations.
 * Supplies methods for Rest Controllers.
 *
 * @author Novaes
 */
@Component
public class BudgetApplicationServiceImpl implements BudgetApplicationService {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    BudgetItemAccountEventMapper budgetItemAccountEventMapper;

    @Override
    public void store(UUID account, ItemDTO itemDTO) {
        Category category = budgetRepository.getItemCategories().stream()
                .filter(c -> c.getId().equals(itemDTO.getCategory().getId()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid Category"));

        Item item = new Item(UUID.randomUUID(),
                itemDTO.getText(),
                category,
                itemDTO.getAmount());
        budgetRepository.store(account, item);
    }

    @Override
    public void store(UUID account, GoalDTO goalDTO) {
        Goal goal = new Goal(UUID.randomUUID(), account, goalDTO.getText(), goalDTO.getAmount(),goalDTO.getInitialWeek()==null?1:goalDTO.getInitialWeek());
        budgetRepository.store(account, goal);
    }

    /**
     * 
     * creates new user budget if doesn't exist
     * 
     * @param account
     * @param startWeek
     * @param endWeek
     * @return 
     */
    @Override
    public BudgetDTO get(UUID account, int startWeek, int endWeek) {
        Budget budget = budgetRepository.get(account);
        BudgetDTO dto;
        if (budget == null) {
            budget = new Budget(account);
            budgetRepository.store(budget);
        }
        dto = Budget.convertToDTO(budgetRepository.get(account), startWeek, endWeek);
        return dto;
    }

    @Override
    public List<Category> getItemCagories() {
        return budgetRepository.getItemCategories();
    }

    @Override
    public void processAccountEvent(AccountEvent accountEvent) {
        Budget b = budgetRepository.get(accountEvent.getAccountId());
        Item item = budgetItemAccountEventMapper.map(b, accountEvent);
        System.out.println(item);
        item.handleAccountEvent(accountEvent.getWeek(), accountEvent);
    }
}
