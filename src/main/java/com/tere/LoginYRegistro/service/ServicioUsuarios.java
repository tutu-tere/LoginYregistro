package com.tere.LoginYRegistro.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Service;

import com.tere.LoginYRegistro.models.LoginUsuario;
import com.tere.LoginYRegistro.models.Usuario;
import com.tere.LoginYRegistro.repository.RepositorioUsuarios;

@Service

public class ServicioUsuarios {

  @Autowired
  private RepositorioUsuarios repoUsuarios;

  public Usuario regristrar(Usuario nuevoUsuario, BindingResult result) {
    String password = nuevoUsuario.getPassword();
    String confirmacion = nuevoUsuario.getConfirmacion();
    if (!password.equals(confirmacion)) {
      result.rejectValue("confirmacion", "Matches", "Los dos campos no coinciden");
    }
    String email = nuevoUsuario.getEmail();
    Usuario existeUsuario = repoUsuarios.findByEmail(email);
    if (existeUsuario != null) {
      result.rejectValue("email", "unique", "El email ya esta registrado, elija otro");
    }
    if (result.hasErrors()) {
      return null;
    } else {
      String passwordHasheado = BCrypt.hashpw(password, BCrypt.gensalt());
      nuevoUsuario.setPassword(passwordHasheado);

      return repoUsuarios.save(nuevoUsuario);
    }
  }
  // validaciones de inicio sesion

  public Usuario login(LoginUsuario usuarioIniciandoSesion, BindingResult result) {
    String email = usuarioIniciandoSesion.getEmailLogin();
    Usuario existeUsuario = repoUsuarios.findByEmail(email);
    if (existeUsuario == null) {
      result.rejectValue("emailLogin", "Unique", "E-mail no registrado");
    } else if (!BCrypt.checkpw(usuarioIniciandoSesion.getPasswordLogin(), existeUsuario.getPassword())) {
      result.rejectValue("passwordLogin", "Matches", "Password incorrecto");
    }
    if (result.hasErrors()) {
      return null;
    } else {
      return existeUsuario;
    }
  }
}
