package com.bestanswer.demonstracao.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CategoriaPergunta {

    CONSELHOS(1L, "Conselhos"),
    CULTURA(2L, "Cultura"),
    CURIOSIDADES(3L, "Curiosidades"),
    EDUCACAO(4L, "Educação"),
    ENTRETENIMENTO(5L, "Entretenimento"),
    ESPORTES(6L, "Esportes"),
    RELIGIAO(7L, "Religião"),
    SAUDE(8L, "Saúde"),
    TECNOLOGIA(9L, "Tecnologia");

    private Long identificador;

    private String nome;

    public static CategoriaPergunta findCategoriaById(Long identificador) {
        return Arrays.stream(values())
                .filter(c -> c.getIdentificador().equals(identificador))
                .findFirst().orElse(null);
    }
}
