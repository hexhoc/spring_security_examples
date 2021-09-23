package com.example.spring_security.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "profile")
    private List<Account> accounts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "profile_authorities",
            joinColumns = @JoinColumn(name = "profile_name"),
            inverseJoinColumns = @JoinColumn(name = "authorities_name")
    )
    private List<Authority> Authorities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Authority> getAuthorities() {
        return Authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        Authorities = authorities;
    }
}
