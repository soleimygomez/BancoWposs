package com.prueba.wposs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaDto {
    private  String numeroCuenta;
    private  String cuentaTranferir;
    private  float monto;
}
