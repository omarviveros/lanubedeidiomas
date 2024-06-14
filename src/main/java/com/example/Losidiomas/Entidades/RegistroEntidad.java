
package com.example.Losidiomas.Entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="bitacora")
public class RegistroEntidad {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    private String matricula;
    private Date fecha;
    private LocalTime hora_entrada;
    private LocalTime hora_salida;
    private int total_horas;

    public RegistroEntidad() {
    }

    public RegistroEntidad(Integer id, String matricula, Date fecha, LocalTime hora_entrada, LocalTime hora_salida, int total_horas) {
        this.id = id;
        this.matricula = matricula;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.total_horas = total_horas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getTotal_horas() {
        return total_horas;
    }

    public void setTotal_horas(int total_horas) {
        this.total_horas = total_horas;
    }

     public void calcularTotalHoras() {
        if (this.hora_entrada != null && this.hora_salida != null) {
            Duration duration = Duration.between(this.hora_entrada, this.hora_salida);
            this.total_horas = (int) duration.toHours();
        } else {
            this.total_horas = 0;
        }
    }
    
}
