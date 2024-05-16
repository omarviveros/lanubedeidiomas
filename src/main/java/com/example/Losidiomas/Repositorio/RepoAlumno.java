
package com.example.Losidiomas.Repositorio;

import com.example.Losidiomas.Entidades.EntidadAlumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoAlumno extends JpaRepository<EntidadAlumno, Integer> {
    List<EntidadAlumno> findByNusuario(String nusuario);
  
}
