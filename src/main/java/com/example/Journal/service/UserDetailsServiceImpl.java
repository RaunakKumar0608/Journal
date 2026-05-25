package com.example.Journal.service;
import com.example.Journal.entity.User;
import org.springframework.stereotype.Component;
import com.example.Journal.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = repo.findByUsername(username);
    try{
        
        return org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .roles(user.getRoles().toArray(new String[0]))
        .build();
       
    }catch(Exception e){
        throw new UsernameNotFoundException("Username <" + username + ">    not found");
    }
    }
}