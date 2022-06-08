package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.mapper.UserConverter;
import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.repository.UserRepository;
import com.angularSpring.demoAngSpring.security.UserLogged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         User user = userRepository.getUserByEmail(email);
         return UserLogged.build(user);
    }


}
