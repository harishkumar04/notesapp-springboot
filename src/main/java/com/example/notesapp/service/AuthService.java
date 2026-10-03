package com.example.notesapp.service;

import com.example.notesapp.dto.RegisterRequest;
import com.example.notesapp.entity.User;
import com.example.notesapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepo.save(user);
    }
}
