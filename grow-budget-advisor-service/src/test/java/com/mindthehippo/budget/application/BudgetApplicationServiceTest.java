/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.budget.application;

import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.aggregate.budget.Category;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.application.dto.GoalDTO;
import com.mindthehippo.budget.application.dto.ItemDTO;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Novaes
 */
@RunWith(SpringJUnit4ClassRunner.class)
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
        Mockito.when(budgetRepository.getItens(new UUID(10, 20))).
                thenReturn(Arrays.asList(new Item(new UUID(1, 2),
                        new Category(new UUID(1, 2), "Salary"), 1000F)));
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
        UUID budget = new UUID(10, 20);
        List<ItemDTO> expResult = Arrays.asList(new ItemDTO(1000F, "Salary"));
        List<ItemDTO> result = budgetApplicationService.getItens(budget);
        assertEquals(expResult.get(0).getAmount(), result.get(0).getAmount(), 0);
        assertEquals(expResult.get(0).getCategory(), result.get(0).getCategory());
        
    }

    /**
     * Test of getGoals method, of class BudgetApplicationService.
     */
    @org.junit.Test
    public void testGetGoals() {
        System.out.println("getGoals");
        UUID budget = null;
        List<GoalDTO> expResult = null;
        List<GoalDTO> result = budgetApplicationService.getGoals(budget);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
