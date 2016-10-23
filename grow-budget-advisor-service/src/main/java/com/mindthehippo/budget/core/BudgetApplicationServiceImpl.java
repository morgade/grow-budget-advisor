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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
        Goal goal = new Goal(UUID.randomUUID(), account, goalDTO.getText(), goalDTO.getAmount(),goalDTO.getInitialWeek());
        budgetRepository.store(account, goal);
    }

    @Override
    public BudgetDTO get(UUID account) {
        Budget budget = budgetRepository.get(account);
        BudgetDTO dto;
        if (budget == null) {
            budget = new Budget(account);
            budgetRepository.store(budget);
        }
        dto = Budget.convertToDTO(budgetRepository.get(account));
        Map<Integer, Float> weekRealized = calculateWeeklyRealized(budget);
        dto.setWeekRealized(weekRealized);
        return dto;
    }

    private Map<Integer, Float> calculateWeeklyRealized(Budget budget) {
        int currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        Map<Integer, Float> r = new HashMap<>();
        for (int i = 0; i <10; i++) {

            float totalRealized = 0;
            final int index = currentWeek-i;
            totalRealized = budget.getItems().stream().map(item -> item.getActualByWeek(index)).reduce(Float::sum).get();

            r.put(index, totalRealized);
        }
        return r;

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
        item.addAccountEvent(accountEvent.getWeek(), accountEvent);
    }
}
