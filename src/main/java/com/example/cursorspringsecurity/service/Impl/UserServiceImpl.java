package com.example.cursorspringsecurity.service.Impl;

import com.example.cursorspringsecurity.entity.WebUser;
import com.example.cursorspringsecurity.repository.UserRepository;
import com.example.cursorspringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public WebUser createUser(WebUser user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public WebUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }


}
