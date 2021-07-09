package com.prueba.wposs.dao;

import com.prueba.wposs.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao  extends JpaRepository<UsuarioEntity,Long> {

}
