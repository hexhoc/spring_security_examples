package com.example.spring_security.configuration;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //-----------------------------------------------------------------------------------------------
        //MOCK DB (Hard Coded Users): <username, {"password", "ROLE"}>
        HashMap<String, String[]> usersTable = new HashMap<>();
        usersTable.put("user", new String[]{"pass", "ROLE_USER"});
        usersTable.put("admin", new String[]{"pass", "ROLE_ADMIN"});
        //-----------------------------------------------------------------------------------------------

        //GET USER/ACCOUNT (From DB)
        String[] user = usersTable.get(username);

        //CHECK IF USER/ACCOUNT EXISTS
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("user is not found by username " + username);
        }

        //GET PASSWORD
        String userPassword = user[0];

        //GET AUTHORITIES
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user[1]));

        return new User(username, userPassword, grantedAuthorities);
    }
}
