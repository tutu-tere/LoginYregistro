package com.tere.LoginYRegistro.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginUsuario {
  @NotBlank(message = "El email es obligatorio")
  @Email(message = "Ingrese un email valido")
  private String emailLogin;

  @NotBlank(message = "El password es obligatorio")
  private String passwordLogin;

  public LoginUsuario() {

  }

  public String getEmailLogin() {
    return emailLogin;
  }

  public void setEmailLogin(String emailLogin) {
    this.emailLogin = emailLogin;
  }

  public String getPasswordLogin() {
    return passwordLogin;
  }

  public void setPasswordLogin(String passwordLogin) {
    this.passwordLogin = passwordLogin;
  }

}
