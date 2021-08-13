package com.bestanswer.demonstracao.service;

import com.bestanswer.demonstracao.domain.CategoriaPergunta;
import com.bestanswer.demonstracao.domain.Pergunta;
import com.bestanswer.demonstracao.dto.PerguntaListaResponse;
import com.bestanswer.demonstracao.dto.PerguntaRequest;
import com.bestanswer.demonstracao.dto.PerguntaResponse;
import com.bestanswer.demonstracao.repository.PerguntaRepository;
import com.bestanswer.demonstracao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerguntaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private PerguntaRepository perguntaRepository;

    public Long publicar(PerguntaRequest request) {
        Long usuarioLogado = usuarioService.getUsuarioLogado();
        Pergunta pergunta = Pergunta.builder()
                .idCategoria(request.getIdCategoria())
                .data(LocalDateTime.now())
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .idUsuario(usuarioLogado)
                .quantidadeRespostas(0)
                .build();
        pergunta = perguntaRepository.save(pergunta);
        return pergunta.getId();
    }

    public List<PerguntaListaResponse> bucarTodas() {
        return perguntaRepository.findAll(Sort.by(Sort.Direction.DESC, "data"))
                .stream().map(p -> PerguntaListaResponse.builder()
                        .id(p.getId())
                        .data(DateUtil.formatarData(p.getData()))
                        .descricaoCategoria(CategoriaPergunta.findCategoriaById(p.getIdCategoria()).getNome())
                        .titulo(p.getTitulo())
                        .quantidadeRespostas(p.getQuantidadeRespostas())
                        .build())
                .collect(Collectors.toList());
    }

    public PerguntaResponse buscarPorId(Long id) {
        Pergunta pergunta = perguntaRepository.findById(id).orElse(null);
        Long idUsuarioLogado = usuarioService.getUsuarioLogado();
        List<PerguntaResponse.RespostaResponse> respostas = respostaService.buscarRespostasDePergunta(id)
                .stream().map(r -> PerguntaResponse.RespostaResponse.builder()
                        .id(r.getId())
                        .conteudo(r.getConteudo())
                        .data(DateUtil.formatarData(r.getData()))
                        .idUsuario(r.getIdUsuario())
                        .nomeUsuario(usuarioService.getUsuarioById(r.getIdUsuario()).getNome())
                        .build()).collect(Collectors.toList());
        PerguntaResponse response = PerguntaResponse.builder()
                .id(pergunta.getId())
                .data(DateUtil.formatarData(pergunta.getData()))
                .idUsuario(pergunta.getIdUsuario())
                .nomeUsuario(usuarioService.getUsuarioById(pergunta.getIdUsuario()).getNome())
                .titulo(pergunta.getTitulo())
                .descricao(pergunta.getDescricao())
                .descricaoCategoria(CategoriaPergunta.findCategoriaById(pergunta.getIdCategoria()).getNome())
                .quantidadeRespostas(pergunta.getQuantidadeRespostas())
                .usuarioLogadoRespondeu(respostas.stream().anyMatch(r -> r.getIdUsuario().equals(idUsuarioLogado)))
                .respostas(respostas)
                .build();
        return response;
    }

    public void incrementarNumeroRespostas(Long idPergunta) {
        perguntaRepository.incrementarNumeroRespostas(idPergunta);
    }
}
