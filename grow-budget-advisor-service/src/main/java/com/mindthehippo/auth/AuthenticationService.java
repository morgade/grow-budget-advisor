package com.mindthehippo.auth;

import java.util.UUID;

/**
 *
 */
public interface AuthenticationService {
    public UUID authenticate(String email, String password);
}
