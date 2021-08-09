package com.bestanswer.demonstracao.repository;

import com.bestanswer.demonstracao.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
