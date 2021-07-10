package com.prueba.wposs.services.impl;


import com.prueba.wposs.dao.UsuarioDao;
import com.prueba.wposs.dto.DepositoDto;
import com.prueba.wposs.dto.RetiroDto;
import com.prueba.wposs.dto.TransferenciaDto;
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
                () -> new ExcepcionSinDatos("Usuario no encontrado")
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

        UsuarioEntity usuarioEntity = buscarNCuenta(retirar.getNumeroCuenta());
        if (retirar.getRetiro() <= usuarioEntity.getMonto()) {
            float tmp = usuarioEntity.getMonto() - retirar.getRetiro();
            usuarioEntity.setMonto(tmp);
            usuarioDao.save(usuarioEntity);
            message = "Su  Retiro fue Exitoso su saldo disponible es " + tmp;
        } else {
            throw new ExcepcionValorInvalido("No  tiene salgo disponible");
        }
        return message;
    }

    public UsuarioEntity buscarNCuenta(String numeroCuenta) {
        return usuarioDao.findByNumeroCuenta(numeroCuenta);
    }

    public String deposito(DepositoDto deposito) {
        String message = null;
        UsuarioEntity usuarioEntity = buscarNCuenta(deposito.getNumeroCuenta());
        if (usuarioEntity.isEstado() == true) {
            if (deposito.getDeposito() > 0) {
                float tmp = usuarioEntity.getMonto() + deposito.getDeposito();
                usuarioEntity.setMonto(tmp);
                usuarioDao.save(usuarioEntity);
                message = "En el numero de Cuenta" + deposito.getNumeroCuenta() + "su nuevo saldo es " + tmp;
            } else {
                throw new ExcepcionValorInvalido("Monto Invalido debe ser superior a 0");
            }
        } else {
            throw new ExcepcionValorInvalido("Estado inactivo");
        }
        return message;
    }

    public String transferencia(TransferenciaDto tranferencia) {
        String message = null;
        UsuarioEntity usuarioatransferir = buscarNCuenta(tranferencia.getCuentaTranferir());
        UsuarioEntity usuarioarealizartranferencia = buscarNCuenta(tranferencia.getNumeroCuenta());

        if (usuarioatransferir != usuarioarealizartranferencia) {
            if (tranferencia.getMonto() <= usuarioarealizartranferencia.getMonto() && tranferencia.getMonto() > 0) {
                if (usuarioarealizartranferencia.isEstado() == true && usuarioatransferir.isEstado() == true) {

                    float tmp = usuarioatransferir.getMonto() + tranferencia.getMonto();
                    float tmp1 = usuarioarealizartranferencia.getMonto() - tranferencia.getMonto();
                    usuarioatransferir.setMonto(tmp);
                    usuarioarealizartranferencia.setMonto(tmp1);
                    usuarioDao.save(usuarioatransferir);
                    usuarioDao.save(usuarioarealizartranferencia);
                    message = "Transferencia Exitosa al numero de cuenta " + tranferencia.getCuentaTranferir() + " su nuevo saldo es " + tmp;
                } else {
                    throw new ExcepcionValorInvalido("La cuenta esta inactiva no se puede realizar la tranferencia");
                }
            } else {
                throw new ExcepcionValorInvalido("Fondos Insuficientes");
            }
        } else {
            throw new ExcepcionValorInvalido("No se puede Tranferir dinero a su misma Cuenta");
        }
        return message;
    }

    public String login(String numeroCuenta, String clave) {

        return null;
    }

}



