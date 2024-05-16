
package com.example.Losidiomas.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="usuario")
public class EntidadLogin {
    
    @Id
    private int idusuario;
    private String usuariouv;
    private String contra;
    private Date fecha;

    public EntidadLogin() {
    }

    public EntidadLogin(int idusuario, String usuariouv, String contra, Date fecha) {
        this.idusuario = idusuario;
        this.usuariouv = usuariouv;
        this.contra = contra;
        this.fecha = fecha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuariouv() {
        return usuariouv;
    }

    public void setUsuariouv(String usuariouv) {
        this.usuariouv = usuariouv;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    
    
    
}