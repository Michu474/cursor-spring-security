package com.example.cursorspringsecurity.repository;

import com.example.cursorspringsecurity.entity.WebUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<WebUser, Long> {

    Optional<WebUser> findByUsername(String username);
}
