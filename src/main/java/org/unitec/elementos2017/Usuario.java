package org.unitec.elementos2017;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    private Long cuenta;
    private String nombre;
    private String email;

    public Usuario() {
    }

    public Usuario(Long cuenta, String nombre, String email) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario(Long cuenta) {
        this.cuenta = cuenta;
    }

    public Long getCuenta() {
        return cuenta;
    }

    public void setCuenta(Long cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
