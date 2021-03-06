package com.mindthehippo.budget.application;

import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Novaes
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetApplicationServiceTest {

    @Autowired
    BudgetApplicationService budgetApplicationService;

    @Autowired
    BudgetRepository budgetRepository;

    public BudgetApplicationServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class BudgetApplicationService.
     */
    @org.junit.Test
    public void testGet() {
        UUID account = UUID.fromString("7f713be0-b7ed-4aba-b69c-972ee3203253");
        List<ItemDTO> items = Arrays.asList(new ItemDTO(UUID.randomUUID().toString(),
                1000F, "Water/sewer",
                new Category("UTILITIES", "UTILITIES", false)));
        BudgetDTO budgetDTO = new BudgetDTO(account.toString(), items, Collections.EMPTY_LIST);
        BudgetDTO expBudget = budgetApplicationService.get(account, 1, 10);
        assertEquals(expBudget.getAccount(), budgetDTO.getAccount());
    }
}
