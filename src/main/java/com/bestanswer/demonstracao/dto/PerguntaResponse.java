package com.bestanswer.demonstracao.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PerguntaResponse {

    private Long id;

    private String descricaoCategoria;

    private LocalDateTime data;

    private String titulo;

    private String descricao;

    private int quantidadeRespostas;

    private Long idUsuario;

    private String nomeUsuario;

    private boolean usuarioLogadoRespondeu;

    private List<RespostaResponse> respostas;

    @Data
    @Builder
    public static class RespostaResponse {

        private Long id;

        private LocalDateTime data;

        private String conteudo;

        private Long idUsuario;

        private String nomeUsuario;
    }
}
