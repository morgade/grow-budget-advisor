package com.mindthehippo.account.interfaces;

import com.mindthehippo.account.AccountEvent;
import com.mindthehippo.account.EventDispatcher;
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
    private EventDispatcher eventManager;
    
    @RequestMapping(path = "/accountEvent", method = RequestMethod.PUT)
    public AccountEvent put(AccountEvent accountEvent){
        //No persistence for now, just notifying clients
        eventManager.dispatch(accountEvent);
        return accountEvent;
    }
    
    
}
