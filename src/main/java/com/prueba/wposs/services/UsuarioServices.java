package com.prueba.wposs.services;

import com.prueba.wposs.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioServices {

    List<UsuarioEntity> allUsuario();

    Long register(UsuarioEntity usuarioEntity);
}
