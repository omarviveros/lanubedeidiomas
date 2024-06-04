
package com.example.Losidiomas.Controlador;

import com.example.Losidiomas.Entidades.EntidadAlumno;
import com.example.Losidiomas.Entidades.EntidadLogin;
import com.example.Losidiomas.Entidades.RegistroEntidad;
import com.example.Losidiomas.Listas.ListadoDatos;
import com.example.Losidiomas.Repositorio.RepoLogin;
import com.example.Losidiomas.Servicios.ServicioRegistro;
import com.example.Losidiomas.Servicios.ServiciosAlumno;
import com.example.Losidiomas.Servicios.ServiciosLogin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centroidiomas")
public class IdiomasPrincipal {
    
    @Autowired
    ServiciosLogin slogin;
    
    @Autowired
    ServiciosAlumno salumno;
    
    @Autowired
    ServicioRegistro sregistro;
    
    @Autowired
    RepoLogin rlogin;

    
    //codigo para usuarios de login
    //proyecto final 8 o 10 de junio 
    
    @GetMapping("/idiomaslista")
    public List<EntidadLogin> mostrarDatos(){
        return slogin.obtenerusuario();
    }
    
    // endpoint iniciar sesion 
    
    @PostMapping("/iniciosesion")
    public String login(@RequestBody EntidadLogin loginRequest){
        EntidadLogin usuario = rlogin.findByUsuariouvAndContra(loginRequest.getUsuariouv(), loginRequest.getContra());
        if (usuario != null) {
            return "Inicio de sesión correcta: " + usuario.getUsuariouv();
        } else {
            return "Usuario y/o contraseña incorrectos";
        }
    }
    
    
    @PostMapping("/guardarusuarios")
    public List<EntidadLogin> guardarusuario(int idusuario, String usuariouv, String contra, String fecha){
        EntidadLogin l = new EntidadLogin();
        l.setIdusuario(idusuario);
        l.setUsuariouv(usuariouv);
        l.setContra(contra);
      
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date fechaDate = formatoOriginal.parse(fecha);
            l.setFecha(fechaDate);
        } catch (ParseException e) {
            // Manejar la excepción si la conversión de fecha falla
            e.printStackTrace();
        }
        
        if (slogin.guardarusuario(l)) {
            return slogin.obtenerusuario();
        }
        return null;
    
    
    }
    
    @PutMapping("/editarusuarios")
    public List<EntidadLogin> editarusuario(int idusuario, String usuariouv, String contra, String fecha){
        EntidadLogin l = new EntidadLogin();
        l.setIdusuario(idusuario);
        l.setUsuariouv(usuariouv);
        l.setContra(contra);
         SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date fechaDate = formatoOriginal.parse(fecha);
            l.setFecha(fechaDate);
        } catch (ParseException e) {
            // Manejar la excepción si la conversión de fecha falla
            e.printStackTrace();
        }
        
        if(slogin.editarusuario(l)){
            return slogin.obtenerusuario();
        }
        return null;
    }
    
    @DeleteMapping("/eliminarusuarios")
    public List<EntidadLogin> eliminarusuario(int idusuario){
        EntidadLogin l = new EntidadLogin();
        l.setIdusuario(idusuario);
        
        
        if(slogin.eliminarusuario(l)){
            return slogin.obtenerusuario();
        }
        return null;
    }
    
    //codigo para registro de alumnos
    
    @GetMapping("/alumno")
    public List<EntidadAlumno> mostrAralumno(){
        return salumno.obteneralumno();
    }
 
     @PostMapping("/guardaralumno")
    public List<EntidadAlumno> guardaralumnos(Integer id, String nusuario,  String nombre, String dependencia, int tipousuario, int semestre, String grupo, String tipoalumno, String valida ,Date fecha){
        EntidadAlumno a = new EntidadAlumno();
       a.setId(id);
       a.setNusuario(nusuario);
       a.setNombre(nombre);
       a.setDependencia(dependencia);
       a.setTipousuario(tipousuario);
       a.setSemestre(semestre);
       a.setGrupo(grupo);
       a.setTipoalumno(tipoalumno);
       a.setValida(valida);
       SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");

        a.setFecha(fecha); // Establecer la fecha como Date
        
        if (salumno.guardaralumno(a)) {
            return salumno.obteneralumno();
        }
        return null;
    }
    
    @PutMapping("/editaralumno")
    public List<EntidadAlumno> editarralumnos(Integer id, String nusuario,  String nombre, String dependencia, int tipousuario, int semestre, String grupo, String tipoalumno, String valida ,Date fecha){
        EntidadAlumno a = new EntidadAlumno();
       a.setId(id);
       a.setNusuario(nusuario);
       a.setNombre(nombre);
       a.setDependencia(dependencia);
       a.setTipousuario(tipousuario);
       a.setSemestre(semestre);
       a.setGrupo(grupo);
       a.setTipoalumno(tipoalumno);
       a.setValida(valida);
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");

        a.setFecha(fecha);
        if(salumno.editaralumno(a)){
            return salumno.obteneralumno();
        }
        return null;
    }
    
    @DeleteMapping("/eliminaralumno")
    public List<EntidadAlumno> eliminaralumnos(Integer id){
        EntidadAlumno a = new EntidadAlumno();
       a.setId(id);
      
        if(salumno.eliminaralumno(a)){
            return salumno.obteneralumno();
        }
        return null;
    }
    
    @GetMapping("/buscaralu")
    public List<EntidadAlumno> obtenerDatos(@RequestParam("nusuario") String nusuario) {
    return salumno.buscaralumno(nusuario);
    }
    
    //codigo para registro de bitacoras
    
    @GetMapping("/mostrarregistroslista")
    public List<RegistroEntidad> mostrarRegistros(){
        return sregistro.obtenerRegistro();
    }
    
    @PostMapping("/guardarregistro")
    public List<RegistroEntidad> guardaRegistros(Integer id, String matricula, Date fecha, LocalTime hora_entrada, LocalTime hora_salida, String totalHorasStr){
        RegistroEntidad r = new RegistroEntidad();
       r.setId(id);
       r.setMatricula(matricula);
       SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");
       r.setFecha(fecha);
       r.setHora_entrada(hora_entrada);
       r.setHora_salida(hora_salida);
     
        r.calcularTotalHoras();
    
    if (sregistro.guardarRegistro(r)) {
        return sregistro.obtenerRegistro();
    }
    return null;

    }

    @PutMapping("/editarregistro")
    public List<RegistroEntidad> editaRegistros(Integer id, String matricula, Date fecha, LocalTime hora_entrada, LocalTime hora_salida, String totalHorasStr){
        RegistroEntidad r = new RegistroEntidad();
       r.setId(id);
       r.setMatricula(matricula);
       SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");
       r.setFecha(fecha);
       r.setHora_entrada(hora_entrada);
       r.setHora_salida(hora_salida);
     
        r.calcularTotalHoras();
    
    if (sregistro.editarRegistro(r)) {
        return sregistro.obtenerRegistro();
    }
    return null;

    }
    
    @DeleteMapping("/eliminarregistro")
    public List<RegistroEntidad> eliminarregistro(Integer id){
        RegistroEntidad r = new RegistroEntidad();
       r.setId(id);
      
        if(sregistro.eliminarRegistro(r)){
            return sregistro.obtenerRegistro();
        }
        return null;
    }
    
    @GetMapping("/buscarmatriculas")
    public List<RegistroEntidad> obtenerMatriculas(@RequestParam("matricula") String matricula) {
    return sregistro.buscaraMatricula(matricula);
    }
   
   @GetMapping("/bitacoras")
   public List<ListadoDatos> obtenerTodo() {
    List<ListadoDatos> listaTodo = new ArrayList<>();
    
    List<EntidadAlumno> listaAlumno = salumno.obteneralumno();
    List<RegistroEntidad> listaRegistro = sregistro.obtenerRegistro();
    
    for (EntidadAlumno alumno : listaAlumno) {
        ListadoDatos datosCombinados = new ListadoDatos();
        datosCombinados.setNusuarioalu(alumno.getNusuario());
        datosCombinados.setNombrealu(alumno.getNombre());
        datosCombinados.setDependenciaalu(alumno.getDependencia());
        datosCombinados.setTipousuariolu(alumno.getTipousuario());
        datosCombinados.setSemestrealu(alumno.getSemestre());
        datosCombinados.setGrupoalu(alumno.getGrupo());
        
        // Buscar el registro correspondiente al alumno
        RegistroEntidad registroAlumno = null;
        for (RegistroEntidad registro : listaRegistro) {
            if (registro.getId() == alumno.getId()) {
                registroAlumno = registro;
                break;
            }
        }
        
        if (registroAlumno != null) {
            datosCombinados.setIdregi(registroAlumno.getId());
            datosCombinados.setMatricularegi(registroAlumno.getMatricula());
            datosCombinados.setFecharegi(registroAlumno.getFecha());
            datosCombinados.setTotal_horasregi(registroAlumno.getTotal_horas());
        } else {
            datosCombinados.setIdregi(null);
            datosCombinados.setMatricularegi(null);
            datosCombinados.setFecharegi(null);
            datosCombinados.setTotal_horasregi(0);
        }
        
        listaTodo.add(datosCombinados);
    }
    
    return listaTodo;
    }
}
    