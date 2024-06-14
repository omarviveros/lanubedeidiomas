
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
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public ResponseEntity<Map<String, String>> login(@RequestBody EntidadLogin loginRequest){
    EntidadLogin usuario = rlogin.findByUsuariouvAndContra(loginRequest.getUsuariouv(), loginRequest.getContra());
    if (usuario != null) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Inicio de sesión correcta");
        response.put("usuario", usuario.getUsuariouv());
        return ResponseEntity.ok(response);
    } else {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Usuario y/o contraseña incorrectos");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
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
public ResponseEntity<?> editarUsuario(@RequestBody EntidadLogin usuario) {
    try {
        // Intenta editar el usuario
        boolean exito = slogin.editarusuario(usuario);
        if (exito) {
            // Si la edición es exitosa, devuelve la lista actualizada de usuarios
            List<EntidadLogin> usuariosActualizados = slogin.obtenerusuario();
            return ResponseEntity.ok(usuariosActualizados);
        } else {
            // Si la edición falla, devuelve un mensaje de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo editar el usuario.");
        }
    } catch (Exception e) {
        // Maneja otros errores
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error al editar el usuario.");
    }
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
    public List<EntidadAlumno> guardaralumnos(Integer id, String nusuario, String nombre, String dependencia, int tipousuario, int semestre, String grupo, String tipoalumno, String valida, String fecha) {
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

    SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd");
    try {
        a.setFecha(formatoOriginal.parse(fecha)); // Convertir la fecha de String a Date
    } catch (ParseException e) {
        e.printStackTrace();
        return null; // Manejar el error según tu lógica
    }

    if (salumno.guardaralumno(a)) {
        return salumno.obteneralumno();
    }
    return null;
}

    @PutMapping("/editaralumno")
public List<EntidadAlumno> editarralumnos(@RequestBody EntidadAlumno alumno) {
    try {
        // Aquí puedes validar y procesar el objeto 'alumno' recibido desde el frontend
        if(salumno.editaralumno(alumno)) {
            return salumno.obteneralumno();
        }
    } catch (Exception error) {
        System.out.println("Error al editar el alumno: " + error.getMessage());
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
    public ResponseEntity<?> guardarRegistro(
            @RequestParam(required = false) Integer id,
            @RequestParam String matricula,
            @RequestParam String fecha,
            @RequestParam(required = false) String hora_entrada,
            @RequestParam(required = false) String hora_salida,
            @RequestParam(required = false) String totalHorasStr) {
        
        System.out.println("Parámetros recibidos: id=" + id + ", matricula=" + matricula + 
            ", fecha=" + fecha + ", hora_entrada=" + hora_entrada + 
            ", hora_salida=" + hora_salida + ", totalHorasStr=" + totalHorasStr);
        
        RegistroEntidad r = new RegistroEntidad();
        r.setId(id);
        r.setMatricula(matricula);
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Date fechaParsed = formatoFecha.parse(fecha);
            r.setFecha(fechaParsed);
            
            if (hora_entrada != null && !hora_entrada.isEmpty()) {
                LocalTime horaEntradaParsed = LocalTime.parse(hora_entrada);
                r.setHora_entrada(horaEntradaParsed);
            }
            
            if (hora_salida != null && !hora_salida.isEmpty()) {
                LocalTime horaSalidaParsed = LocalTime.parse(hora_salida);
                r.setHora_salida(horaSalidaParsed);
            }
            
        } catch (ParseException | DateTimeParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solicitud incorrecta: formato de fecha u hora inválido");
        }
        
        r.calcularTotalHoras();
        
        if (sregistro.guardarRegistro(r)) {
            return ResponseEntity.ok(sregistro.obtenerRegistro());
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el registro");
    }
    

   @PutMapping("/editarregistro")
    public List<RegistroEntidad> editaRegistros(
            @RequestParam Integer id,
            @RequestParam String matricula,
            @RequestParam String fecha, // Recibida como String en formato dd/MM/yyyy
            @RequestParam String hora_entrada, // Recibida como String en formato HH:mm:ss
            @RequestParam String hora_salida, // Recibida como String en formato HH:mm:ss
            @RequestParam String totalHorasStr) {

        RegistroEntidad r = new RegistroEntidad();
        r.setId(id);
        r.setMatricula(matricula);

        // Formatear fecha y horas
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        try {
            Date fechaParsed = formatoFecha.parse(fecha);
            r.setFecha(fechaParsed);

            if (hora_entrada != null && !hora_entrada.isEmpty()) {
                LocalTime horaEntradaParsed = LocalTime.parse(hora_entrada);
                r.setHora_entrada(horaEntradaParsed);
            }

            if (hora_salida != null && !hora_salida.isEmpty()) {
                LocalTime horaSalidaParsed = LocalTime.parse(hora_salida);
                r.setHora_salida(horaSalidaParsed);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Manejar el error según sea necesario
        }

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
   
     @GetMapping("/bitacoras/{matricularegi}")
    public List<ListadoDatos> obtenerPorMatriculaRegi(@PathVariable String matricularegi) {
        List<ListadoDatos> resultados = new ArrayList<>();
        List<ListadoDatos> listaTodo = obtenerTodo(); // Obtener todos los datos primero

        for (ListadoDatos datos : listaTodo) {
            if (datos.getMatricularegi() != null && datos.getMatricularegi().equals(matricularegi)) {
                resultados.add(datos);
            }
        }

        return resultados;
    }
   
}
    