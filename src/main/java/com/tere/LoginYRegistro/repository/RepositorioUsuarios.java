package com.tere.LoginYRegistro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tere.LoginYRegistro.models.Usuario;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {

  Usuario findByEmail(String email);

}
