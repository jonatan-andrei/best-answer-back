package com.bestanswer.demonstracao.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private final String token;

    private final String nomeUsuario;

}
