package com.bestanswer.demonstracao.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@SequenceGenerator(name = "generator_resposta", sequenceName = "sequence_resposta", initialValue = 1, allocationSize = 1)
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_resposta")
    private Long id;

    private LocalDateTime data;

    private String conteudo;

    private Long idPergunta;

    private Long idUsuario;

}
