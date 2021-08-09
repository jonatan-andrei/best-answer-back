package com.bestanswer.demonstracao.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class PerguntaListaResponse {

    private Long id;

    private String descricaoCategoria;

    private LocalDateTime data;

    private String titulo;

    private int quantidadeRespostas;

}
