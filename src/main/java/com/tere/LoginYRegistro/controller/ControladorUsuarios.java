package com.tere.LoginYRegistro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tere.LoginYRegistro.models.LoginUsuario;
import com.tere.LoginYRegistro.models.Usuario;
import com.tere.LoginYRegistro.service.ServicioUsuarios;

@Controller
public class ControladorUsuarios {
  @Autowired
  private ServicioUsuarios su;

  @GetMapping("/")
  public String index(@ModelAttribute("nuevoUsuario") Usuario nuevUsuario,
      @ModelAttribute("loginUsuario") LoginUsuario usuarioIniciandoSesion) {
    return "index.jsp";
  }
}
