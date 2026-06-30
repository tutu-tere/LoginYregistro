package com.tere.LoginYRegistro.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;

@Entity
@Table(name = "usuarios")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "Ingresa tú nombre")
  @Size(min = 3, max = 50, message = "El nombre debe tener al menos 3 caracteres")
  private String nombre;

  @NotBlank(message = "Ingresa tú apellido")
  @Size(min = 3, max = 50, message = "El apellido debe tener al menos 3 caracteres")
  private String apellido;

  @NotNull(message = "Debes ingresar tu fecha de nacimiento")
  @Past(message = "La fecha debe ser anterior a hoy")
  @Column(name = "fecha_nacimiento")
  private LocalDate fechaNacimiento;

  @NotBlank(message = "Ingresa tu e-mail")
  @Email(message = "Ingresa un email valido")
  private String email;

  @NotBlank(message = "Ingresa tu contraseña")
  @Size(min = 8, message = "Debe tener al menos 8 caracteres")
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$", message = "Debes incluir al menos una letra mayuscula, una letra minuscula y un numero")
  private String password;

  @Transient
  private String confirmacion;

  @CreationTimestamp
  @Column(name = "fecha_creacion", updatable = false)
  private LocalDateTime fechaCreacion;

  @UpdateTimestamp
  @Column(name = "fecha_actualizacion")
  private LocalDateTime fechaActualizacion;

  public Usuario() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmacion() {
    return confirmacion;
  }

  public void setConfirmacion(String confirmacion) {
    this.confirmacion = confirmacion;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public LocalDateTime getFechaActualizacion() {
    return fechaActualizacion;
  }

  public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }

}
