package com.dashboard.model;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dashboard.Entities.User;
import com.dashboard.Repositories.UserRepository;

@Service
public class AuthRegister{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            throw new RuntimeException("El usuario ya existe");
        }

        User user = new User();
        
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setCreate_date(LocalDateTime.now());
        user.setLast_access(LocalDateTime.now());
        user.setActive(true);
        // Puedes asignar roles predeterminados si deseas
        return userRepository.save(user);
    }
}

