package com.bestanswer.demonstracao.controller;

import com.bestanswer.demonstracao.dto.LoginRequest;
import com.bestanswer.demonstracao.dto.LoginResponse;
import com.bestanswer.demonstracao.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        String token = loginService.login(request.getEmail(), request.getSenha());
        return ResponseEntity.ok().body(new LoginResponse(token));
    }

}
