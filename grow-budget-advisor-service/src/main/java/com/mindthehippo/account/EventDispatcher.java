package com.mindthehippo.account;

/**
 * The account service EventDispatcher interface
 * @author Lucas
 */
public interface EventDispatcher {
    /**
     * Dispatches an account event to its subscribers
     * @param event 
     */
    void dispatch(AccountEvent event);
}
