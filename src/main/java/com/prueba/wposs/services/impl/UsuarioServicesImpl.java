package com.prueba.wposs.services.impl;

import com.ayd.aulas.excepcion.ExcepcionValorInvalido;
import com.prueba.wposs.dao.UsuarioDao;
import com.prueba.wposs.entity.UsuarioEntity;
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

    @Override
    public Long register(UsuarioEntity usuarioEntity) {


        if (usuarioEntity.getClave().length() >= 8 && usuarioEntity.getCelular().length() == 10 && usuarioEntity.isEstado() == true) {

            usuarioEntity.setNumeroCuenta("1" + usuarioEntity.getCelular());
            usuarioEntity.setMonto(4000000);

        } else {
           new ExcepcionValorInvalido("No cumple los Parametros Requeridos");
         }
        return usuarioDao.save(usuarioEntity).getId();


    }

}
