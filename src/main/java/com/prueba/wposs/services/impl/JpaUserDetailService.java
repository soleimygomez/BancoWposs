package com.prueba.wposs.services.impl;

import com.prueba.wposs.dao.UsuarioDao;
import com.prueba.wposs.entity.UsuarioEntity;
import com.prueba.wposs.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("jpaUserDetailService")
public class JpaUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioDao.findByNumeroCuenta(s);
        if (Objects.isNull(usuarioEntity)) {
            throw new ExcepcionSinDatos("No se encontro al usuario");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return new User(usuarioEntity.getNumeroCuenta(),
                usuarioEntity.getClave(),
                usuarioEntity.isEstado(),
                true,
                true,
                true,
                authorities);
    }
}
