package com.siwes.LibrarySystem.auth;

import com.siwes.LibrarySystem.user.Roles;

public record RegistrationRequest(
        String firstname,
        String lastname,
        String email,
        String password,
        String address,
        Roles role
) {
}
