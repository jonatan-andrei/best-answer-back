package com.bestanswer.demonstracao.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@SequenceGenerator(name = "generator_pergunta", sequenceName = "sequence_pergunta", initialValue = 1, allocationSize = 1)
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_pergunta")
    private Long id;

    private Long idCategoria;

    private LocalDateTime data;

    private String titulo;

    private String descricao;

    private Long idUsuario;

    private Integer quantidadeRespostas;

}
