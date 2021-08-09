package com.bestanswer.demonstracao.dto;

import lombok.Data;

@Data
public class PerguntaRequest {

    private Long idCategoria;

    private String titulo;

    private String descricao;

}
