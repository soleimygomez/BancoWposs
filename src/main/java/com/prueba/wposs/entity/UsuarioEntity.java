package com.prueba.wposs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;
import org.intellij.lang.annotations.RegExp;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @ManyToOne
    private TipoDocumentoEntity tipoDocumento;
    private Integer identificacion;
    private String celular;
    private String email;


    private String clave;
    private boolean estado;
    private String numeroCuenta;
    private float monto;

}
