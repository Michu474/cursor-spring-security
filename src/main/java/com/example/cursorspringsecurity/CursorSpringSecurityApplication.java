package com.example.cursorspringsecurity;

import com.example.cursorspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursorSpringSecurityApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursorSpringSecurityApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        userRepository.save(WebUser.builder().username("Dima").password("1234").build());
    }
}
