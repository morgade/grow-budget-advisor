package com.mindthehippo.account;

import com.mindthehippo.account.core.MockedAccountEventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */
@RestController
public class MockedEventsController {
 
    @Autowired
    private MockedAccountEventManager eventManager;
    
    @RequestMapping(path = "/accountEvent", method = RequestMethod.PUT)
    public AccountEvent put(AccountEvent accountEvent){
        eventManager.dispatch(accountEvent);
        return accountEvent;
    }
}
