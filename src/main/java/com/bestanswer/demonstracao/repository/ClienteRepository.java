package com.bestanswer.demonstracao.repository;

import com.bestanswer.demonstracao.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
