package com.geekbrains.demo.configuration;

import com.geekbrains.demo.entity.Account;
import com.geekbrains.demo.repository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //FIND ACCOUNT
        Account account = accountRepository.findByName(username);

        //CHECK IF NOT FOUND
        if (Objects.isNull(account)) {
            throw new UsernameNotFoundException(username);
        }

        //CREATE GRANTED AUTHORITY
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(account.getRole()));

        //USER IS COMPLETE
        UserDetails user = new User(username, account.getPassword(), grantedAuthorities);

        return user;
    }
}
