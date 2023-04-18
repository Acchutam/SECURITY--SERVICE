package com.securityservice.config;

import com.securityservice.entities.Admin;
import com.securityservice.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository repository;
    @Override
    public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
       Optional<Admin> admin=repository.findByAdminName(adminName);
        return admin.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found with name:"+adminName));
    }
}
