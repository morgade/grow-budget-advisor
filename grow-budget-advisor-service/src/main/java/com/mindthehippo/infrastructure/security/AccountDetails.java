/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.infrastructure.security;

import com.mindthehippo.account.Account;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Inject Account information Security Principal
 * mockAccount must be replaced by a service 
 * to recover user account.
 *
 * @author Novaes
 */
@Component
public class AccountDetails implements UserDetailsService {

    @Value("${mock.account}")
    private String mockAccount;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //service.loadAccountFromUser(username);
        return new Account(UUID.fromString(mockAccount));
    }

}
