package com.geekbrains.demo.configuration;

import com.geekbrains.demo.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity()
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //ALL REQUEST FOR AUTHENTICATED USERS

        http.authorizeRequests()
                .antMatchers("/product/show/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers("/product/new").hasAnyRole("ADMIN", "USER")
                .antMatchers("/product/create").hasRole("ADMIN")
                .antMatchers("/product/update").hasRole("ADMIN")
                .antMatchers("/product/delete").hasRole("ADMIN")
                .antMatchers("/product/list").permitAll()
                .anyRequest().authenticated();

        //REDIRECT TO DEFAULT LOGIN FORM
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/product/list")
                .usernameParameter("username")
                .passwordParameter("password");

        http.logout()
                .logoutSuccessUrl("/product/list");
    }
}
