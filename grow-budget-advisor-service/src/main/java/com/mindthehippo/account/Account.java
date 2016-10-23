package com.mindthehippo.account;

import java.util.UUID;
import org.springframework.security.core.userdetails.User;

/**
 * User Account Information. 
 * It will be persisted in Security Principal.
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
