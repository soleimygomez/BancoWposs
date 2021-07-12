package com.prueba.wposs.services;

import com.prueba.wposs.dto.DepositoDto;
import com.prueba.wposs.dto.LoginDto;
import com.prueba.wposs.dto.RetiroDto;
import com.prueba.wposs.dto.TransferenciaDto;
import com.prueba.wposs.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioServices {

    List<UsuarioEntity> allUsuario();

    Long register(UsuarioEntity usuarioEntity);

    String retiro(RetiroDto retirar);

    String deposito(DepositoDto deposito);

    String transferencia(TransferenciaDto tranferencia);

    String login(LoginDto login);
}
