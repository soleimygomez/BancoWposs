package com.prueba.wposs.services.impl;


import com.prueba.wposs.dao.UsuarioDao;
import com.prueba.wposs.dto.RetiroDto;
import com.prueba.wposs.entity.UsuarioEntity;
import com.prueba.wposs.excepcion.ExcepcionSinDatos;
import com.prueba.wposs.excepcion.ExcepcionValorInvalido;
import com.prueba.wposs.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<UsuarioEntity> allUsuario() {
        return usuarioDao.findAll();
    }

    public UsuarioEntity searchBy(Long id) {
        return usuarioDao.findById(id).orElseThrow(
                ()->new ExcepcionSinDatos("Usuario no encontrado")
        );
    }

    @Override
    public Long register(UsuarioEntity usuarioEntity) {


        if (usuarioEntity.getClave().length() >= 8 && usuarioEntity.getCelular().length() == 10 && usuarioEntity.isEstado() == true) {

            usuarioEntity.setNumeroCuenta("1" + usuarioEntity.getCelular());
            usuarioEntity.setMonto(4000000);

        } else {
            throw new ExcepcionValorInvalido("No cumple los Parametros Requeridos");
        }
        return usuarioDao.save(usuarioEntity).getId();

    }

    public String retiro(RetiroDto retirar) {
        String message = null;
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        if (retirar.getRetiro()  <= usuarioEntity.getMonto()) {
            float tmp = usuarioEntity.getMonto() - retirar.getRetiro();
            usuarioEntity.setMonto(tmp);

            message = "Su  Retiro fue Exitoso su saldo disponible es " + tmp;
        } else {
            throw new ExcepcionValorInvalido("No  tiene salgo disponible");
        }
        return message;
    }

    public UsuarioEntity buscarNCuenta(String numeroCuenta){
        return usuarioDao.findByNumeroCuenta(numeroCuenta);
    }

    public String deposito(float deposito, String numeroCuenta) {
        String message = null;
        UsuarioEntity usuarioEntity = buscarNCuenta(numeroCuenta);
        if (deposito > 0) {
            float tmp = usuarioEntity.getMonto() + deposito;
            usuarioEntity.setMonto(tmp);
            usuarioDao.save(usuarioEntity);
            message = "En el numero de Cuenta"+ numeroCuenta +"su nuevo saldo es " + tmp  ;
        } else {
            throw new ExcepcionValorInvalido("Monto Invalido debe ser superior a 0");
        }
        return message;
        }

    }



