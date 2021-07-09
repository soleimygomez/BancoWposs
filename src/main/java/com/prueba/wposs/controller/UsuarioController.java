package com.prueba.wposs.controller;

import com.prueba.wposs.dto.RetiroDto;
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

    @GetMapping (name = "/listar")
    public List<UsuarioEntity> all(){
        return usuarioServices.allUsuario();
    }

    @PostMapping (name = "/registro")
    public Long register(@RequestBody UsuarioEntity usuarioEntity){
        return usuarioServices.register(usuarioEntity);
    }


    @PostMapping (name = "/retiro")
    public String retiro(@RequestBody RetiroDto retirar) {
        return usuarioServices.retiro(retirar);
    }
}
