package com.mindthehippo;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.account.EventType;
import com.mindthehippo.account.interfaces.MockedEventsController;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Lucas
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetAdvisorApplicationTest {

    @Autowired
    MockedEventsController c;
    
    @Test
    public void contextLoads() {
        AccountEvent e1 = new AccountEvent(UUID.fromString("7b68f7e8-2ea6-4bfb-8be5-1ab3037de14f"), EventType.DEBIT, "teste1", 126510.12f,12);
        AccountEvent e2 = new AccountEvent(UUID.fromString("7b68f7e8-2ea6-4bfb-8be5-1ab3037de14f"), EventType.CREDIT, "teste2", 121210.12f,13);
        AccountEvent e3 = new AccountEvent(UUID.fromString("7b68f7e8-2ea6-4bfb-8be5-1ab3037de14f"), EventType.DEBIT, "teste3", 121650.12f,14);
        AccountEvent e4 = new AccountEvent(UUID.fromString("7b68f7e8-2ea6-4bfb-8be5-1ab3037de14f"), EventType.CREDIT, "teste4", 121210.12f,15);
        c.put(e1);
        c.put(e2);
        c.put(e3);
        c.put(e4);
    }

}
