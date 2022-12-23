package com.example.cursorspringsecurity.service;

import com.example.cursorspringsecurity.entity.WebUser;

public interface UserService {
    WebUser createUser(WebUser user);

    void deleteUserById(Long id);

    WebUser getUserById(Long id);
}
