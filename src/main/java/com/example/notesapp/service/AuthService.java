package com.example.notesapp.service;

import com.example.notesapp.dto.LoginRequestDTO;
import com.example.notesapp.dto.RegisterRequest;
import com.example.notesapp.entity.User;
import com.example.notesapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public void register(RegisterRequest dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepo.save(user);
    }

    public String login(LoginRequestDTO dto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(),dto.getPassword()));
        return jwtUtil.generateToken(dto.getUserName());
    }
}
