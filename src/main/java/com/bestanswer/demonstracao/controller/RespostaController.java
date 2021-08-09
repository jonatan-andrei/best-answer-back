package com.bestanswer.demonstracao.controller;

import com.bestanswer.demonstracao.dto.RespostaRequest;
import com.bestanswer.demonstracao.service.PerguntaService;
import com.bestanswer.demonstracao.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private PerguntaService perguntaService;

    @PostMapping
    @Transactional
    public ResponseEntity publicar(@RequestBody RespostaRequest request) {
        respostaService.publicar(request);
        perguntaService.incrementarNumeroRespostas(request.getIdPergunta());
        return ResponseEntity.ok().build();
    }
}
