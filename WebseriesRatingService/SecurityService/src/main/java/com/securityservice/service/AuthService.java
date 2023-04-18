package com.securityservice.service;

import com.securityservice.entities.Admin;
import com.securityservice.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class  AuthService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private  JwtService jwtService;

    public String saveAdmin(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
                return "admin added";
    }
    public  String generateToken(String adminName)
    {
        return jwtService.generateToken(adminName);
    }
    public  void validateToken(String token)
    {
        jwtService.validateToken(token);
    }

}
