
package com.example.Losidiomas.Listas;

import java.util.Date;

public class ListadoDatos {
    
    private String nusuarioalu;
    private String nombrealu;
    private String dependenciaalu;
    private int tipousuariolu;
    private int semestrealu;
    private String grupoalu;
    private Integer idregi;
    private String matricularegi;
    private Date fecharegi;
    private int total_horasregi;

    public ListadoDatos() {
    }

    public ListadoDatos(String nusuarioalu, String nombrealu, String dependenciaalu, int tipousuariolu, int semestrealu, String grupoalu, Integer idregi, String matricularegi, Date fecharegi, int total_horasregi) {
        this.nusuarioalu = nusuarioalu;
        this.nombrealu = nombrealu;
        this.dependenciaalu = dependenciaalu;
        this.tipousuariolu = tipousuariolu;
        this.semestrealu = semestrealu;
        this.grupoalu = grupoalu;
        this.idregi = idregi;
        this.matricularegi = matricularegi;
        this.fecharegi = fecharegi;
        this.total_horasregi = total_horasregi;
    }

    public String getNusuarioalu() {
        return nusuarioalu;
    }

    public void setNusuarioalu(String nusuarioalu) {
        this.nusuarioalu = nusuarioalu;
    }

    public String getNombrealu() {
        return nombrealu;
    }

    public void setNombrealu(String nombrealu) {
        this.nombrealu = nombrealu;
    }

    public String getDependenciaalu() {
        return dependenciaalu;
    }

    public void setDependenciaalu(String dependenciaalu) {
        this.dependenciaalu = dependenciaalu;
    }

    public int getTipousuariolu() {
        return tipousuariolu;
    }

    public void setTipousuariolu(int tipousuariolu) {
        this.tipousuariolu = tipousuariolu;
    }

    public int getSemestrealu() {
        return semestrealu;
    }

    public void setSemestrealu(int semestrealu) {
        this.semestrealu = semestrealu;
    }

    public String getGrupoalu() {
        return grupoalu;
    }

    public void setGrupoalu(String grupoalu) {
        this.grupoalu = grupoalu;
    }

    public Integer getIdregi() {
        return idregi;
    }

    public void setIdregi(Integer idregi) {
        this.idregi = idregi;
    }

    public String getMatricularegi() {
        return matricularegi;
    }

    public void setMatricularegi(String matricularegi) {
        this.matricularegi = matricularegi;
    }

    public Date getFecharegi() {
        return fecharegi;
    }

    public void setFecharegi(Date fecharegi) {
        this.fecharegi = fecharegi;
    }

    public int getTotal_horasregi() {
        return total_horasregi;
    }

    public void setTotal_horasregi(int total_horasregi) {
        this.total_horasregi = total_horasregi;
    }

   
}
