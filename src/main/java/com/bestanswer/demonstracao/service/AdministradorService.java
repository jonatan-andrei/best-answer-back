package com.bestanswer.demonstracao.service;

import com.bestanswer.demonstracao.domain.Administrador;
import com.bestanswer.demonstracao.exception.UsuarioJaCadastradoException;
import com.bestanswer.demonstracao.repository.AdministradorRepository;
import com.bestanswer.demonstracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void cadastrar(String email, String senha, String nome) {
        if (usuarioRepository.findByEmail(email).isPresent()) {
            throw new UsuarioJaCadastradoException();
        }
        Administrador administrador = new Administrador();
        administrador.setEmail(email);
        administrador.setSenha(passwordEncoder.encode(senha));
        administrador.setNome(nome);
        administradorRepository.save(administrador);
    }
}
