package com.codecrafters.urbanalertgt.controller;

import com.codecrafters.urbanalertgt.model.Estado;
import com.codecrafters.urbanalertgt.repository.RepositoryEstado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final RepositoryEstado repo;

    public EstadoController(RepositoryEstado repo){
        this.repo = repo;
    }

    @GetMapping
    public List<Estado> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Estado guardar(@RequestBody Estado e){
        return repo.save(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizar(@PathVariable Long id,
                                             @RequestBody Estado estado){

        if (!repo.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        estado.setIdEstado(id);
        return ResponseEntity.ok(repo.save(estado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Long id){
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){

        if (!repo.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
