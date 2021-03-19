package com.example.transonicweb.interactor.user;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import com.example.transonicweb.domain.user.LoginUser;
import com.example.transonicweb.domain.user.User;
import com.example.transonicweb.domain.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import lombok.extern.apachecommons.CommonsLog;


@Component
@CommonsLog
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) throw new UsernameNotFoundException("");

        Optional<User> result = userRepository.findByName(username);
        User user = result.get();
        log.info("user" + user.getName());

        return new LoginUser(user.getId(), user.getName(),
            user.getPassword(), Boolean.TRUE, getAuthorities("ROLE_USER"));
        // アカウントの有効期限切れ、アカウントのロック、パスワードの有効期限切れ、ユーザの無効を判定
        // if (!user.isAccountNonExpired() || !user.isAccountNonLocked() ||
        //         !user.isCredentialsNonExpired() || !user.isEnabled())
        //     throw new UsernameNotFoundException("");
        // return user;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
}
