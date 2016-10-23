/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.infrastructure.mock;

import com.mindthehippo.account.EventDispatcher;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.goal.Goal;
import com.mindthehippo.budget.core.BudgetInMemoryRepository;
import static java.lang.Math.random;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Novaes
 */
public class MockService {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    private EventDispatcher eventManager;

    public static final Map<String, UUID> userAccounts = new HashMap<>();

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
        Map<String, Category> categories = budgetRepository.getItemCategories().stream().collect(Collectors.toMap(c-> c.getId(), c-> c));
//        String[] names = new String[]{"Paycheck", "Electricity", "Water/sewer"};
        if (!categories.isEmpty()
                && budgetRepository.get(fullAccount) == null) {
            budgetRepository.store(new Budget(fullAccount));
//            for (int i = 0; i < 20; i++) {
//                Random random = new Random();
//                int categoryIndex = random.nextInt(3);
//                budgetRepository.store(fullAccount,
//                        new Item(UUID.randomUUID(), names[categoryIndex],
//                                categories.get(categoryIndex),
//                                random.nextInt(1000)));
//            }

            Random random = new Random();
            budgetRepository.store(fullAccount, 
                    new Item(UUID.randomUUID(), 
                            "Salary", 
                            categories.get(BudgetInMemoryRepository.CATEGORY_PAYCHECK), 
                            random.nextInt(100)+400));
            budgetRepository.store(fullAccount, 
                    new Item(UUID.randomUUID(), 
                            "Electricity", 
                            categories.get(BudgetInMemoryRepository.CATEGORY_UTILITIES), 
                            random.nextInt(50)+10));
            budgetRepository.store(fullAccount, 
                    new Item(UUID.randomUUID(), 
                            "Internet", 
                            categories.get(BudgetInMemoryRepository.CATEGORY_UTILITIES), 
                            random.nextInt(70)+10));
            budgetRepository.store(fullAccount, 
                    new Item(UUID.randomUUID(), 
                            "Taxes", 
                            categories.get(BudgetInMemoryRepository.CATEGORY_TAXES), 
                            random.nextInt(80)+10));
            budgetRepository.store(fullAccount, 
                    new Item(UUID.randomUUID(), 
                            "Car Loan Installments", 
                            categories.get(BudgetInMemoryRepository.CATEGORY_LOAN), 
                            random.nextInt(100)+40));
            budgetRepository.store(fullAccount, 
                    new Item(UUID.randomUUID(), 
                            "Credit Card debts",  
                            categories.get(BudgetInMemoryRepository.CATEGORY_LOAN), 
                            random.nextInt(200)+50));
            Goal g1 = new Goal(UUID.randomUUID(),fullAccount,"Trip to the Moon",20000000f,1);
            Goal g2 = new Goal(UUID.randomUUID(),fullAccount,"New Boat",150000f,1);
            Goal g3 = new Goal(UUID.randomUUID(),fullAccount,"XMas",5000f,1);
            budgetRepository.store(fullAccount, g1);
            budgetRepository.store(fullAccount, g2);
            budgetRepository.store(fullAccount, g3);

        }
    }
}
