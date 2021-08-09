package com.bestanswer.demonstracao.controller;

import com.bestanswer.demonstracao.dto.CadastroRequest;
import com.bestanswer.demonstracao.dto.LoginRequest;
import com.bestanswer.demonstracao.dto.LoginResponse;
import com.bestanswer.demonstracao.common.AbstractConfigurationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginControllerTest extends AbstractConfigurationTests {

    @Autowired
    private LoginController loginController;

    @Autowired
    private CadastroController cadastroController;

    @Test
    public void loginValido() {
        // Arrange
        String email = "jonatan@jonatan.com";
        String senha = "abcd1234";

        CadastroRequest requestCadastro = CadastroRequest.builder()
                .email(email)
                .senha(senha)
                .build();
        cadastroController.cadastrar(requestCadastro);

        LoginRequest request = LoginRequest.builder()
                .email(email)
                .senha(senha)
                .build();

        // Act
        ResponseEntity<LoginResponse> response = loginController.login(request);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertTrue(nonNull(response.getBody().getToken()));
    }

    @Test(expected = BadCredentialsException.class)
    public void loginInvalido() {
        // Arrange
        String email = "jonatan@jonatan.com";
        String senha = "abcd1234";

        LoginRequest request = LoginRequest.builder()
                .email(email)
                .senha(senha)
                .build();

        // Act
        ResponseEntity<LoginResponse> response = loginController.login(request);
    }

}
