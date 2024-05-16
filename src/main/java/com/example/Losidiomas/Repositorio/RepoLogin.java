
package com.example.Losidiomas.Repositorio;

import com.example.Losidiomas.Entidades.EntidadLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoLogin extends JpaRepository <EntidadLogin, Integer> {
    EntidadLogin findByUsuariouvAndContra(String usuariouv, String contra);
}
