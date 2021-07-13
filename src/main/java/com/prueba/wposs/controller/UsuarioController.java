package com.prueba.wposs.controller;

import com.prueba.wposs.dto.*;
import com.prueba.wposs.entity.UsuarioEntity;
import com.prueba.wposs.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping("/listar")
    public List<UsuarioEntity> all() {
        return usuarioServices.allUsuario();
    }

    @PostMapping("/registrar")
    public Long register(@RequestBody UsuarioDto usuariodto) {
        return usuarioServices.register(usuariodto);
    }

    @PostMapping("/retiro")
    public String retiro(@RequestBody RetiroDto retirar) {
        return usuarioServices.retiro(retirar);
    }

    @PostMapping("/deposito")
    String deposito(@RequestBody DepositoDto deposito) {
        return usuarioServices.deposito(deposito);
    }

    @PostMapping("/tranferencia")
    String transferencia(@RequestBody TransferenciaDto tranferencia) {
        return usuarioServices.transferencia(tranferencia);
    }

    @PostMapping("/login")
    String login(@RequestBody LoginDto login) {
        return usuarioServices.login(login);
    }


}
