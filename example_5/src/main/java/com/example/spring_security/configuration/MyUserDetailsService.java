package com.example.spring_security.configuration;

import com.example.spring_security.entity.Account;
import com.example.spring_security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private AccountRepository accountRepository;

    @Autowired
    public MyUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //GET USER/ACCOUNT (From DB)
        Account account = accountRepository.findByUsername(username);

        //CHECK IF USER/ACCOUNT EXISTS
        if (Objects.isNull(account)) {
            throw new UsernameNotFoundException("user is not found by username " + username);
        }

        //GET PASSWORD
        String userPassword = account.getPassword();

        //GET AUTHORITIES
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(account.getRole()));

        return new User(username, userPassword, grantedAuthorities);
    }
}
