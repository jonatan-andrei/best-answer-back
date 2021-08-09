package com.bestanswer.demonstracao.service;

import com.bestanswer.demonstracao.domain.Resposta;
import com.bestanswer.demonstracao.dto.RespostaRequest;
import com.bestanswer.demonstracao.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Resposta> buscarRespostasDePergunta(Long idPergunta) {
        return respostaRepository.findByIdPergunta(idPergunta);
    }

    public void publicar(RespostaRequest request) {
        respostaRepository.save(Resposta.builder()
                .data(LocalDateTime.now())
                .conteudo(request.getConteudo())
                .idPergunta(request.getIdPergunta())
                .idUsuario(usuarioService.getUsuarioLogado())
                .build());
    }
}
