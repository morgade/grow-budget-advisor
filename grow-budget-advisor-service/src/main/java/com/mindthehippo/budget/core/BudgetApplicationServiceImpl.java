package com.mindthehippo.budget.core;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.application.BudgetApplicationService;
import com.mindthehippo.budget.application.BudgetItemAccountEventMapper;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

    @Autowired
    BudgetItemAccountEventMapper budgetItemAccountEventMapper;

    @Override
    public void store(UUID account, ItemDTO itemDTO) {
        Item item = new Item(UUID.fromString(itemDTO.getText()),
                itemDTO.getText(),
                new Category(UUID.fromString(itemDTO.getCategory()), itemDTO.getCategory()),
                itemDTO.getAmount());
        budgetRepository.store(account, item);
    }

    @Override
    public BudgetDTO get(UUID account) {
        Budget budget = budgetRepository.get(account);
        BudgetDTO dto;
        if (budget == null) {
            budget = new Budget(account);
            budgetRepository.store(budget);
            dto = modelMapper.map(budget, BudgetDTO.class);
        }
        dto = modelMapper.map(budgetRepository.get(account), BudgetDTO.class);
        Map<Integer, Float> weekRealized = calculateWeeklyRealized(budget);
        dto.setWeekRealized(weekRealized);
        return dto;
    }

    private Map<Integer, Float> calculateWeeklyRealized(Budget budget) {
        int currentWeek = Calendar.getInstance().getWeekYear();
        Map<Integer, Float> r = new HashMap<>();
        for (int i = currentWeek; i > currentWeek - 10; i--) {
            float totalRealized = 0;

            totalRealized = budget.getItems().stream().map(item -> item.getActualByWeek(currentWeek)).reduce(Float::sum).get();
            
            r.put(i, totalRealized);
        }
        return r;
    }

    @Override
    public List<Category> getItemCagories() {
        return budgetRepository.getItemCategories();
    }

    @Override
    public void processAccountEvent(AccountEvent accountEvent) {
        System.out.println(accountEvent.getAccountId());
        Budget b = budgetRepository.get(accountEvent.getAccountId());
        System.out.println(b);
        Item item = budgetItemAccountEventMapper.map(b, accountEvent);
        item.addAccountEvent(accountEvent.getWeek(), accountEvent);
    }
}
