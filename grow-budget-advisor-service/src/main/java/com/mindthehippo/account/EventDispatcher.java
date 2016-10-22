package com.mindthehippo.account;

/**
 *
 * @author Lucas
 */
public interface EventDispatcher {

    void dispatch(AccountEvent event);
}
