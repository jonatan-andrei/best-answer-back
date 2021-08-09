package com.bestanswer.demonstracao.domain;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario {

    @Override
    public Perfil getPerfil() {
        return Perfil.ADMINISTRADOR;
    }

}
