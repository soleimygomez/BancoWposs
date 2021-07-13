package com.prueba.wposs.services.impl;


import com.prueba.wposs.dao.UsuarioDao;
import com.prueba.wposs.dto.*;
import com.prueba.wposs.entity.UsuarioEntity;
import com.prueba.wposs.excepcion.ExcepcionSinDatos;
import com.prueba.wposs.excepcion.ExcepcionValorInvalido;
import com.prueba.wposs.services.UsuarioServices;
import org.aspectj.bridge.IMessage;
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
    public Long register(UsuarioDto usuariodto) {
        boolean respuesta=false;
        List<UsuarioEntity> usuarios = allUsuario();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdentificacion().equals(usuariodto.getIdentificacion()) || usuarios.get(i).getNombre().equals(usuariodto.getNombre()) || usuarios.get(i).getCelular().equals(usuariodto.getCelular()) || usuarios.get(i).getEmail().equals(usuariodto.getEmail())) {
                respuesta = true;
                break;
            }
        }

        if (respuesta == false) {

            if (usuariodto.getClave().length() >= 8 ) {
                if (usuariodto.getCelular().length() == 10) {
                    if (usuariodto.getEmail().contains("@gmail.com") || usuariodto.getEmail().contains("@hotmail.com")) {
                        if (usuariodto.getIdentificacion() > 0) {

                            UsuarioEntity usuarioEntity= new UsuarioEntity();
                            usuarioEntity.setNumeroCuenta("1" + usuariodto.getCelular());
                            usuarioEntity.setMonto(4000000);
                            usuarioEntity.setCelular(usuariodto.getCelular());
                            usuarioEntity.setClave(usuariodto.getClave());
                            usuarioEntity.setNombre(usuariodto.getNombre());
                            usuarioEntity.setIdentificacion(usuariodto.getIdentificacion());
                            usuarioEntity.setEmail(usuariodto.getEmail());
                            usuarioEntity.setEstado(true);
                            usuarioDao.save(usuarioEntity).getId();
                        } else {
                            throw new ExcepcionValorInvalido("Identificacion incorrecta");
                        }
                    } else {
                        throw new ExcepcionValorInvalido("Correo electronico incorrecto");
                    }
                } else {
                    throw new ExcepcionValorInvalido("El numero de celular debe contener 10 digitos");
                }
            } else {
                throw new ExcepcionValorInvalido("la Clave debe ser mayor a 8 ");
            }

        } else {
            throw new ExcepcionValorInvalido("Este usuario ya esta registrado ");
        }

        return null;

    }

    public String retiro(RetiroDto retirar) {
        String message = null;

        UsuarioEntity usuarioEntity = buscarNCuenta(retirar.getNumeroCuenta());

        if (usuarioEntity.getMonto() > 0) {
            if (retirar.getRetiro() <= usuarioEntity.getMonto()) {
                float tmp = usuarioEntity.getMonto() - retirar.getRetiro();
                usuarioEntity.setMonto(tmp);
                usuarioDao.save(usuarioEntity);
                message = "Su  Retiro fue Exitoso su saldo disponible es " + tmp;
            } else {
                throw new ExcepcionValorInvalido("No  tiene salgo disponible");
            }
        } else {
            throw new ExcepcionValorInvalido("Monto Invalido debe ser superior a 0");
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
            if (usuarioarealizartranferencia.getMonto() > 0) {
                if (tranferencia.getMonto() <= usuarioarealizartranferencia.getMonto()) {
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
                    throw new ExcepcionValorInvalido("Fondos Insuficientes  ");
                }
            } else {
                throw new ExcepcionValorInvalido(" Monto a Transferir debe ser mayor a 0");
            }
        } else {
            throw new ExcepcionValorInvalido("No se puede Tranferir dinero a su misma Cuenta");
        }
        return message;
    }

    public String login(LoginDto login) {

        String message = null;
        List<UsuarioEntity> usuarioEntity = allUsuario();

        for (int i = 0; i < usuarioEntity.size(); i++) {
            if (usuarioEntity.get(i).getNumeroCuenta().equals(login.getNumeroCuenta()) && login.getNumeroCuenta() != null) {
                if (usuarioEntity.get(i).getClave().equals(login.getClave()) && login.getClave() != null) {
                    message = "ya estas logeado ";
                } else {
                    message = "contraseña incorrecta ";
                }
                break;
            } else {
                message = "usuario incorrecto ";
            }

        }

        return message;
    }

}



