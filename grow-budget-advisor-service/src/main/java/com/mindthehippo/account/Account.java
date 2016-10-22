/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindthehippo.account;

import java.util.Collection;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Novaes
 */
public class Account extends User {

    private final UUID id;

    public Account(UUID id) {
        super(null, null, null);
        this.id = id;
    }
}
