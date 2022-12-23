package com.example.cursorspringsecurity.web;

import com.example.cursorspringsecurity.entity.WebUser;
import com.example.cursorspringsecurity.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/")
    private String home() {
        return "home";
    }

    @GetMapping(value = "/user")
    private String user() {
        return "user ";
    }


    @GetMapping(value = "/getUser/{id}")
    private WebUser getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PostMapping(value = "/createUser")
    private WebUser createUser(@RequestBody WebUser user) {
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    private void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping(value = "/admin/{id}")
    private String admin() {
        return "admin ";
    }
}
