package com.codecrafters.urbanalertgt.repository;

import com.codecrafters.urbanalertgt.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail (String email);
}
