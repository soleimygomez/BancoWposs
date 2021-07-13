package com.prueba.wposs.services;

import com.prueba.wposs.dto.*;
import com.prueba.wposs.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioServices {

    List<UsuarioEntity> allUsuario();

    Long register(UsuarioDto usuariodto);

    String retiro(RetiroDto retirar);

    String deposito(DepositoDto deposito);

    String transferencia(TransferenciaDto tranferencia);

    String login(LoginDto login);
}
