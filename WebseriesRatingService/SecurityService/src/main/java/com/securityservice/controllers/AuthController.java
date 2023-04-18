package com.securityservice.controllers;

import com.securityservice.dto.AuthRequest;
import com.securityservice.entities.Admin;
import com.securityservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public  String addNewAdmin(@RequestBody Admin admin)
    {
        return service.saveAdmin(admin);
    }
    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest)
    {
       Authentication authenticate= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getAdminName(),authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return service.generateToken(authRequest.getAdminName());
        }
        else {
            throw  new RuntimeException("Invalid acces");
        }


    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token)
    {
         service.validateToken(token);
         return  "Token is valid";

    }

}
