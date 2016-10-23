/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.infrastructure.mock;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.account.EventDispatcher;
import com.mindthehippo.account.EventType;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.goal.Goal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Novaes
 */
public class MockService {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    private EventDispatcher eventManager;

    static final Map<String, UUID> userAccounts = new HashMap<>();

    static {
        userAccounts.put("user", UUID.fromString("7b68f7e8-2ea6-4bfb-8be5-1ab3037de14f"));
        userAccounts.put("dennis", UUID.fromString("7f713be0-b7ed-4aba-b69c-972ee3203253"));
    }

    @PostConstruct
    public void init() {
        mock();
    }

    public UUID getAccount(String user) {
        return userAccounts.get(user);
    }

    public void mock() {
        UUID fullAccount = getAccount("dennis");
        List<Category> categories = budgetRepository.getItemCategories();
        String[] names = new String[]{"Paycheck", "Electricity", "Water/sewer"};
        if (!categories.isEmpty()
                && budgetRepository.get(fullAccount) == null) {
            budgetRepository.store(new Budget(fullAccount));
            for (int i = 0; i < 20; i++) {
                Random random = new Random();
                int categoryIndex = random.nextInt(3);
                budgetRepository.store(fullAccount,
                        new Item(UUID.randomUUID(), names[categoryIndex],
                                categories.get(categoryIndex),
                                random.nextInt(1000)));
            }
            Goal g1 = new Goal(UUID.randomUUID(),fullAccount,"Trip to the Moon",20000000f,0);
            Goal g2 = new Goal(UUID.randomUUID(),fullAccount,"New Boat",150000f,20);
            Goal g3 = new Goal(UUID.randomUUID(),fullAccount,"XMas",5000f,35);
            budgetRepository.store(fullAccount, g1);
            budgetRepository.store(fullAccount, g2);
            budgetRepository.store(fullAccount, g3);

        }
    }
}
