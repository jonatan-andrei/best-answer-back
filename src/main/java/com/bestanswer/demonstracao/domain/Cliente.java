package com.bestanswer.demonstracao.domain;

import javax.persistence.Entity;

import static com.bestanswer.demonstracao.domain.Perfil.CLIENTE;

@Entity
public class Cliente extends Usuario {

    @Override
    public Perfil getPerfil() {
        return CLIENTE;
    }
}
