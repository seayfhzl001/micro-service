package com.ehome.microservice.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SSOUserDetailsService implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String user="user";
        if( !user.equals(s) ) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User( s, passwordEncoder.encode("123456"), 
              AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}