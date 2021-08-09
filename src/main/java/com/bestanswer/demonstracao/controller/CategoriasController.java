package com.bestanswer.demonstracao.controller;

import com.bestanswer.demonstracao.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<String>> listarCategorias() {
        return ResponseEntity.ok().body(categoriasService.listarCategorias());
    }
}
