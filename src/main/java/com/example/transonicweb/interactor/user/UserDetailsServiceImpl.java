package com.example.transonicweb.interactor.user;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.example.transonicweb.domain.user.LoginUser;
import com.example.transonicweb.domain.user.User;
import com.example.transonicweb.domain.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.thymeleaf.util.StringUtils;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginUser loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername=[" + username + "]");
        if (StringUtils.isEmpty(username)) throw new UsernameNotFoundException("");

        Optional<User> result = userRepository.findByName(username);
        User user = result.orElseThrow(()->
            new UsernameNotFoundException("No user found with " + username));
        // パスワード取得
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attrs.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String password = request.getParameter("password");
        if (!user.getPassword().equals(password)) {
            new UsernameNotFoundException("No user found with " + username);
        }
        return new LoginUser(user, getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
}
