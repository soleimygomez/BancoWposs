package com.prueba.wposs.dto;

import com.prueba.wposs.entity.TipoDocumentoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {



    private String nombre;

    private TipoDocumentoDto tipoDocumento;
    private Integer identificacion;
    private String celular;

    private String email;

    private String clave;

}
