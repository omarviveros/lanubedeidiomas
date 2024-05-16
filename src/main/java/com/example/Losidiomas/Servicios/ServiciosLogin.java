
package com.example.Losidiomas.Servicios;

import com.example.Losidiomas.Entidades.EntidadLogin;
import com.example.Losidiomas.Repositorio.RepoLogin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosLogin {
 
    @Autowired
    RepoLogin rlogin;
    
    public List<EntidadLogin> obtenerusuario(){
       return rlogin.findAll();
    }
    
    public boolean guardarusuario(EntidadLogin l){
        boolean respuesta=false;
        try{
            rlogin.save(l);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean editarusuario(EntidadLogin l){
        boolean respuesta=false;
        try{
            rlogin.save(l);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
     public boolean eliminarusuario(EntidadLogin l){
        boolean respuesta=false;
        try{
            rlogin.delete(l);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
     
}
