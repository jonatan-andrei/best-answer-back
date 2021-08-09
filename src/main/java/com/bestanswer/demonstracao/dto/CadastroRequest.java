package com.bestanswer.demonstracao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CadastroRequest {

    private String nome;

    private String email;

    private String senha;
}
