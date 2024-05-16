
package com.example.Losidiomas.Repositorio;

import com.example.Losidiomas.Entidades.RegistroEntidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoRegistro extends JpaRepository <RegistroEntidad, Integer> {
    List<RegistroEntidad> findByMatricula(String matricula);
}

