
package com.example.Losidiomas.Servicios;

import com.example.Losidiomas.Entidades.RegistroEntidad;
import com.example.Losidiomas.Repositorio.RepoRegistro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioRegistro {

@Autowired
RepoRegistro rregistro;
    

 public List<RegistroEntidad> obtenerRegistro(){
        return rregistro.findAll();
    }

  public boolean guardarRegistro(RegistroEntidad r){
        boolean respuesta=false;
        try{
            rregistro.save(r);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
 
  public boolean editarRegistro(RegistroEntidad r){
        boolean respuesta=false;
        try{
            rregistro.save(r);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
  
  public boolean eliminarRegistro(RegistroEntidad r){
        boolean respuesta=false;
        try{
            rregistro.delete(r);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
  
  public List<RegistroEntidad> buscaraMatricula(String matricula) {
    RegistroEntidad matriculaEncontrada = null;
    try {
        List<RegistroEntidad> matriculaOptional = rregistro.findByMatricula(matricula);
          return matriculaOptional;
    
    } catch (Exception error) {
        System.out.println("Error al buscar la matricula: " + error.getMessage());
        return null;
    }
    //return datosOptional;
    
    }  
  
  
  public RegistroEntidad obtenerRegistroPorMatricula(String matricula) {
        try {
            List<RegistroEntidad> registros = rregistro.findByMatricula(matricula);
            if (!registros.isEmpty()) {
                return registros.get(0); // Devuelve el primer registro encontrado
            }
        } catch (Exception error) {
            System.out.println("Error al buscar la matrícula: " + error.getMessage());
        }
        return null;
    }
  
}
