package com.dashboard.Controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.dashboard.Config.JwtUtil;
import com.dashboard.DTOs.RegisterResponse;
import com.dashboard.DTOs.LoginRequest;
import com.dashboard.DTOs.LoginResponse;
import com.dashboard.DTOs.RegisterRequest;
import com.dashboard.Entities.User;
import com.dashboard.Services.CustomUserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private RegisterResponse authService;
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest authRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        System.out.println(jwt);

        return ResponseEntity.ok(new LoginResponse(jwt));
    }
	
	 @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            User user = authService.register(request);
            return ResponseEntity.ok("Usuario registrado con éxito:\n\n" + user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
