package com.mindthehippo.infrastructure.security;

import com.mindthehippo.account.Account;
import com.mindthehippo.infrastructure.mock.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Inject Account information Security Principal
 * mockService returns user account information.
 *
 * @author Novaes
 */
@Component
public class AccountDetails implements UserDetailsService {

    @Autowired
    private MockService mockService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new Account(mockService.getAccount(userName));
    }

}
