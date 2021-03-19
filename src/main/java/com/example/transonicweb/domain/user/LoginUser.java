package com.example.transonicweb.domain.user;

import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser implements UserDetails {
 
    private static final long serialVersionUID = 1L;
 
    private long id;
    private String email;
    private String phoneNo;
    private String name;
    private String password;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;
     
    public LoginUser(long userId, String username, String password, Boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = userId;
        this.name = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
