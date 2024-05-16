
package com.example.Losidiomas.Servicios;

import com.example.Losidiomas.Entidades.EntidadAlumno;
import com.example.Losidiomas.Repositorio.RepoAlumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosAlumno {
    
    @Autowired
    RepoAlumno ralumno;
 
    public List<EntidadAlumno> obteneralumno(){
        return ralumno.findAll();
    }
    
    public boolean guardaralumno(EntidadAlumno a){
        boolean respuesta=false;
        try{
            ralumno.save(a);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean editaralumno(EntidadAlumno a){
        boolean respuesta=false;
        try{
            ralumno.save(a);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean eliminaralumno(EntidadAlumno a){
        boolean respuesta=false;
        try{
            ralumno.delete(a);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public List<EntidadAlumno> buscaralumno(String nusuario) {
    EntidadAlumno alumnoEncontrado = null;
    try {
        List<EntidadAlumno> alumnoOptional = ralumno.findByNusuario(nusuario);
          return alumnoOptional;
    
    } catch (Exception error) {
        System.out.println("Error al buscar el fabricante: " + error.getMessage());
        return null;
    }
    //return datosOptional;
    
    }  
 
                
    
}
