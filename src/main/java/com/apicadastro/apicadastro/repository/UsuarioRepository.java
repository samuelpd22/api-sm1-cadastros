package com.apicadastro.apicadastro.repository;

import com.apicadastro.apicadastro.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
