package com.siwes.LibrarySystem.auth;

import com.siwes.LibrarySystem.user.Roles;
import com.siwes.LibrarySystem.user.UserRepository;
import com.siwes.LibrarySystem.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public void register(RegistrationRequest request) {
        var user = Users.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(encoder.encode(request.password()))
                .address(request.address())
                .role(Roles.ADMIN)
                .build();
        repository.save(user);

        //sendVerificationEmail(user);
    }
}
