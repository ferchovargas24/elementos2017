package org.unitec.elementos2017;

import javax.persistence.*;

@Entity
public class Direccion {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="cuenta")
    private Usuario u;

    private String calle;
    private Integer cp;
    private String municipio;

    public Direccion() {
    }

    public Direccion(Long id) {
        this.id = id;
    }

    public Direccion(Long id, Usuario u, String calle, Integer cp, String municipio) {
        this.setId(id);
        this.setU(u);
        this.setCalle(calle);
        this.setCp(cp);
        this.setMunicipio(municipio);
    }

    public Direccion(Usuario u, String calle, Integer cp, String municipio) {
        this.u = u;
        this.calle = calle;
        this.cp = cp;
        this.municipio = municipio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
