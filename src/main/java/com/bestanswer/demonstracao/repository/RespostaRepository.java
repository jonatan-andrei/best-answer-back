package com.bestanswer.demonstracao.repository;

import com.bestanswer.demonstracao.domain.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    List<Resposta> findByIdPergunta(Long idPergunta);
}
