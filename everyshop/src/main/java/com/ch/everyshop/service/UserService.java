package com.ch.everyshop.service;

import com.ch.everyshop.domain.SiteUser;
import com.ch.everyshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser createUser (String username, String email, String password ) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return user;
    }
}
