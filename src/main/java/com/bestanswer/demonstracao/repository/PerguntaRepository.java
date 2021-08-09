package com.bestanswer.demonstracao.repository;

import com.bestanswer.demonstracao.domain.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    @Modifying
    @Query(value = "UPDATE pergunta p set quantidade_respostas = quantidade_respostas + 1 WHERE p.id = :idPergunta",
            nativeQuery = true)
    void incrementarNumeroRespostas(@Param("idPergunta") Long idPergunta);

}
