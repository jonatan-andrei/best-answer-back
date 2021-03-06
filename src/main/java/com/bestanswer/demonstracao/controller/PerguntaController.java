package com.bestanswer.demonstracao.controller;

import com.bestanswer.demonstracao.domain.Pergunta;
import com.bestanswer.demonstracao.dto.PerguntaListaResponse;
import com.bestanswer.demonstracao.dto.PerguntaRequest;
import com.bestanswer.demonstracao.dto.PerguntaResponse;
import com.bestanswer.demonstracao.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @PostMapping
    public ResponseEntity<Long> publicar(@RequestBody PerguntaRequest request) {
        Long id = perguntaService.publicar(request);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping
    public ResponseEntity<List<PerguntaListaResponse>> bucarTodas() {
        return ResponseEntity.ok().body(perguntaService.bucarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(perguntaService.buscarPorId(id));
    }
}
