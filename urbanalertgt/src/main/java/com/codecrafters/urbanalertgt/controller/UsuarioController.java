package com.codecrafters.urbanalertgt.controller;

import com.codecrafters.urbanalertgt.entity.Usuario;
import com.codecrafters.urbanalertgt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardar(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario(){
        return usuarioService.listar();
    }

    @GetMapping("/email/{email}")
    public Usuario obtenerEmail(@PathVariable String email){
        return usuarioService.buscarPorEmail(email);
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable long id){
        return usuarioService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable long id){
        usuarioService.eliminar(id);
    }


}
