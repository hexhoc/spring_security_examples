package com.example.spring_security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        //LOCK EVERYTHING ELSE (User must be Authorized with proper Roles & Authorities)
//        http.authorizeRequests().anyRequest().authenticated();

//        http.authorizeRequests()
//                .antMatchers("/book/read").hasAuthority("ROLE_USER")
//                .antMatchers("/book/create").hasRole("ADMIN")
//                .antMatchers("/book/delete").hasRole("ADMIN")
//                .antMatchers("/book/update").hasRole("ADMIN");


        //AUTHENTICATE USER WITH DEFAULT LOGIN FORM
        http.formLogin();
    }
}
