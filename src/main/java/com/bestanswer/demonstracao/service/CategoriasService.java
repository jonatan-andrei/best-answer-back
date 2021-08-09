package com.bestanswer.demonstracao.service;

import com.bestanswer.demonstracao.domain.CategoriaPergunta;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriasService {

    public List<String> listarCategorias() {
        return Arrays.stream(CategoriaPergunta.values())
                .map(CategoriaPergunta::getNome)
                .collect(Collectors.toList());
    }
}
