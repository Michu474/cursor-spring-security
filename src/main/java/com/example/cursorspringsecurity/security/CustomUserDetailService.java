package com.example.cursorspringsecurity.security;

import com.example.cursorspringsecurity.entity.WebUser;
import com.example.cursorspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailService implements UserDetailsService { // custom UserDetailsService to connect to the DB and
    // check if credentials are correct

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebUser userByUsername = userRepository.findByUsername(username).orElseThrow();

        if (Objects.equals(userByUsername.getUsername(), username)) {
            System.out.println(username + " +++ " + userByUsername.getUsername());
            return SecurityUser.getUserDetailsFromUser(userByUsername);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
