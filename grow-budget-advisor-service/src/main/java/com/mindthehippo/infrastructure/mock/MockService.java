package com.mindthehippo.infrastructure.mock;

import com.mindthehippo.account.EventDispatcher;
import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.budget.Goal;
import com.mindthehippo.budget.core.BudgetInMemoryRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Contains existing user accounts.
 * Creates an account with fixed data.
 * 
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
        Map<String, Category> categories = budgetRepository.getItemCategories().
                stream().collect(Collectors.toMap(c-> c.getId(), c-> c));
        if (!categories.isEmpty()
                && budgetRepository.get(fullAccount) == null) {
            budgetRepository.store(new Budget(fullAccount));

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
            Goal g3 = new Goal(UUID.randomUUID(),fullAccount,"XMas",100f,1);
            Goal g2 = new Goal(UUID.randomUUID(),fullAccount,"Bike",500f,1);
            Goal g1 = new Goal(UUID.randomUUID(),fullAccount,"Suborbital Spacefligth",1000f,1);
            budgetRepository.store(fullAccount, g1);
            budgetRepository.store(fullAccount, g2);
            budgetRepository.store(fullAccount, g3);

        }
    }
}
