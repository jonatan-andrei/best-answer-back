package com.bestanswer.demonstracao.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PerguntaListaResponse {

    private Long id;

    private String descricaoCategoria;

    private String data;

    private String titulo;

    private int quantidadeRespostas;

}
