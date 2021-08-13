package com.bestanswer.demonstracao.controller;

import com.bestanswer.demonstracao.domain.Usuario;
import com.bestanswer.demonstracao.dto.CadastroRequest;
import com.bestanswer.demonstracao.dto.LoginResponse;
import com.bestanswer.demonstracao.security.LoginService;
import com.bestanswer.demonstracao.service.AdministradorService;
import com.bestanswer.demonstracao.service.ClienteService;
import com.bestanswer.demonstracao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<LoginResponse> cadastrar(@RequestBody CadastroRequest request) {
        clienteService.cadastrar(request.getEmail(), request.getSenha(), request.getNome());
        String token = loginService.login(request.getEmail(), request.getSenha());
        Usuario usuario = usuarioService.findByEmail(request.getEmail()).get();
        return ResponseEntity.ok().body(new LoginResponse(token, usuario.getNome()));
    }

    // Endpoint criado apenas para teste na aplicação

    @PostMapping("/administrador")
    public ResponseEntity<LoginResponse> cadastrarAdministrador(@RequestBody CadastroRequest request) {
        administradorService.cadastrar(request.getEmail(), request.getSenha(), request.getNome());
        String token = loginService.login(request.getEmail(), request.getSenha());
        Usuario usuario = usuarioService.findByEmail(request.getEmail()).get();
        return ResponseEntity.ok().body(new LoginResponse(token, usuario.getNome()));    }

}
