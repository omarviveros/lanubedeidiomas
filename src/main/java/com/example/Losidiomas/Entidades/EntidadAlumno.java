

package com.example.Losidiomas.Entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name="alumnoregistro")
public class EntidadAlumno {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    private String nusuario;
    private String nombre;
    private String dependencia;
    private int tipousuario;
    private int semestre;
    private String grupo;
    private String tipoalumno;
    private String valida;
    private Date fecha;

    public EntidadAlumno() {
    }

    public EntidadAlumno(Integer id, String nusuario, String nombre, String dependencia, int tipousuario, int semestre, String grupo, String tipoalumno, String valida, Date fecha) {
        this.id = id;
        this.nusuario = nusuario;
        this.nombre = nombre;
        this.dependencia = dependencia;
        this.tipousuario = tipousuario;
        this.semestre = semestre;
        this.grupo = grupo;
        this.tipoalumno = tipoalumno;
        this.valida = valida;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNusuario() {
        return nusuario;
    }

    public void setNusuario(String nusuario) {
        this.nusuario = nusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTipoalumno() {
        return tipoalumno;
    }

    public void setTipoalumno(String tipoalumno) {
        this.tipoalumno = tipoalumno;
    }

    public String getValida() {
        return valida;
    }

    public void setValida(String valida) {
        this.valida = valida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

   

    
    
    
    
    
}
