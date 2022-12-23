package com.example.cursorspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // filter chain that we need to check
        // if user has permission to the endpoints
        http.csrf().disable();
        http.authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers("/").permitAll();
                    authConfig.requestMatchers("/getUser/**").permitAll();
                    authConfig.requestMatchers("/createUser").permitAll();
                    authConfig.requestMatchers("/deleteUser").authenticated();
                    authConfig.requestMatchers("/user").authenticated();
                    authConfig.requestMatchers("/admin").denyAll();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        System.out.println(NoOpPasswordEncoder.getInstance().toString());
        return NoOpPasswordEncoder.getInstance();
    }


}
