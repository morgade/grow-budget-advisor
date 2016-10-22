/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.infrastructure.security;

import com.mindthehippo.account.Account;
import com.mindthehippo.infrastructure.mock.MockService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
