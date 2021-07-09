package com.prueba.wposs.dto;

import com.prueba.wposs.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetiroDto {

    private String numeroCuenta;
    private float retiro;
}
