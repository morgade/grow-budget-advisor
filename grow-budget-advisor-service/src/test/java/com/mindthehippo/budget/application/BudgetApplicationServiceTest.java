package com.mindthehippo.budget.application;

import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.aggregate.goal.Goal;
import com.mindthehippo.budget.application.dto.BudgetDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @MockBean
    BudgetRepository budgetRepository;

    public BudgetApplicationServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        UUID uuid = new UUID(10, 20);
        Mockito.when(budgetRepository.get(Matchers.any(UUID.class))).
                thenReturn(
                        new Budget(uuid, Arrays.asList(new Item(UUID.randomUUID(), "Company A", new Category("UTILITIES", "UTILITIES", false), 1000F)), 
                                Arrays.asList(new Goal(uuid, UUID.randomUUID(), "A Goal", 10))
                        )
                );
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getItens method, of class BudgetApplicationService.
     */
    @org.junit.Test
    public void testGetItens() {
        System.out.println("getItens");
        UUID account = new UUID(10, 20);
        List<ItemDTO> items = Arrays.asList(new ItemDTO(UUID.randomUUID().toString(),
                1000F, "Company A",
                new Category("UTILITIES", "UTILITIES", false)));
        BudgetDTO budgetDTO = new BudgetDTO(account.toString(), items, Collections.EMPTY_LIST);
        BudgetDTO expBudget = budgetApplicationService.get(account);
        assertEquals(expBudget.getAccount(), budgetDTO.getAccount());
        assertEquals(expBudget.getItems().get(0).getText(),
                budgetDTO.getItems().get(0).getText());
        assertEquals(expBudget.getItems().get(0).getCategory().getId(),
                budgetDTO.getItems().get(0).getCategory().getId());

    }
}
