package com.bestanswer.demonstracao.controller;

import com.bestanswer.demonstracao.dto.CadastroRequest;
import com.bestanswer.demonstracao.dto.LoginResponse;
import com.bestanswer.demonstracao.common.AbstractConfigurationTests;
import com.bestanswer.demonstracao.exception.UsuarioJaCadastradoException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CadastroControllerTest extends AbstractConfigurationTests {

    @Autowired
    CadastroController cadastroController;

    @Test
    public void cadastrarCliente() {
        // Arrange
        CadastroRequest request = CadastroRequest.builder()
                .email("jonatan@jonatan.com")
                .senha("abcd1234")
                .build();

        // Act
        ResponseEntity<LoginResponse> response = cadastroController.cadastrar(request);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertTrue(nonNull(response.getBody().getToken()));
    }

    @Test(expected = UsuarioJaCadastradoException.class)
    public void tentarCadastrarClienteJaCadastrado() {
        // Arrange
        CadastroRequest request = CadastroRequest.builder()
                .email("jonatan@jonatan.com")
                .senha("abcd1234")
                .build();
        cadastroController.cadastrar(request);

        // Act
        ResponseEntity<LoginResponse> response = cadastroController.cadastrar(request);
    }

}
