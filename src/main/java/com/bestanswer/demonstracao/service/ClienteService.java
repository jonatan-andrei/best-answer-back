package com.bestanswer.demonstracao.service;

import com.bestanswer.demonstracao.domain.Cliente;
import com.bestanswer.demonstracao.exception.UsuarioJaCadastradoException;
import com.bestanswer.demonstracao.repository.ClienteRepository;
import com.bestanswer.demonstracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void cadastrar(String email, String senha, String nome) {
        if (usuarioRepository.findByEmail(email).isPresent()) {
            throw new UsuarioJaCadastradoException();
        }
        Cliente cliente = new Cliente();
        cliente.setEmail(email);
        cliente.setSenha(passwordEncoder.encode(senha));
        cliente.setNome(nome);
        clienteRepository.save(cliente);
    }
}
