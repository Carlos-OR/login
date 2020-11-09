package com.pruebas.iniciodesesion.Repository;

import com.pruebas.iniciodesesion.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

    public Usuario findByUsuario(String usuario);

}
