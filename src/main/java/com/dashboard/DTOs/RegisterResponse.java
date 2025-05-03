package com.dashboard.DTOs;

import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dashboard.Entities.User;
import com.dashboard.Repositories.UserRepository;

@Service
public class RegisterResponse{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
        	JSONObject response = new JSONObject();
        	response.put("error:", "El usuario ya existe");
            throw new RuntimeException(response.toString());
        }

        User user = new User();
        
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setCreate_date(LocalDateTime.now());
        user.setLast_access(LocalDateTime.now());
        user.setActive(true);
        return userRepository.save(user);
    }
}

