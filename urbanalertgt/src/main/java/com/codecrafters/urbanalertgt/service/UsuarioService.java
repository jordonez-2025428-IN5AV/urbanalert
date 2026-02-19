package com.codecrafters.urbanalertgt.service;

import com.codecrafters.urbanalertgt.entity.Usuario;
import com.codecrafters.urbanalertgt.repository.UsuarioRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public void eliminar (long id){
        usuarioRepository.deleteById(id);
    }

}
