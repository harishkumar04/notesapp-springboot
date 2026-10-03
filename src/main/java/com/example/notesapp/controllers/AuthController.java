package com.example.notesapp.controllers;

import com.example.notesapp.dto.RegisterRequest;
import com.example.notesapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public void registerRequest(@RequestBody RegisterRequest dto){
        authService.register(dto);
    }
}
