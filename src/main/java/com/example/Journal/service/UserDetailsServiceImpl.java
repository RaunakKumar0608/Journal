package com.example.Journal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.example.Journal.Dingrepo.userrepo;
import com.example.Journal.Entity.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private userrepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = repo.findByusername(username);
    if(user !=null){
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .roles(user.getRoles().toArray(new String[0]))
        .build();
        return userDetails;
    }
    throw new UsernameNotFoundException("Username not found" + username);
    }
}