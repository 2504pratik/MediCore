package com.example.authservice.service;

import com.example.authservice.dto.JwtResponse;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.model.Role;
import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.util.JwtTokenProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private String jwtSecret = "your_secret_key"; // Change this to a secure secret key
    private int jwtExpirationMs = 86400000; // 1 day

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(RegisterRequest registerRequest) {
        if (existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());
        userRepository.save(user);
    }

    public JwtResponse login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            String token = jwtTokenProvider.generateToken(authentication);
            return new JwtResponse(token, user.getRole());
        }
        throw new RuntimeException("Invalid username or password");
    }

    private String generateJwtToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .claim("role", user.getRole())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public void assignRole(User user, Role role) {
        // Check if the user exists
        if (user == null || role == null) {
            throw new IllegalArgumentException("User or role cannot be null");
        }

        // Set the role for the user
        user.setRole(role);

        // Save the updated user back to the repository
        userRepository.save(user);
    }
}