package com.codecrafters.urbanalertgt.controller;

import com.codecrafters.urbanalertgt.model.Reporte;
import com.codecrafters.urbanalertgt.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> obtenerTodos() {
        return ResponseEntity.ok(reporteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerPorId(@PathVariable Long id) {
        return reporteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reporte> crear(@RequestBody Reporte reporte) {
        Reporte nuevo = reporteService.guardar(reporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizar(@PathVariable Long id, @RequestBody Reporte reporte) {
        try {
            Reporte actualizado = reporteService.actualizar(id, reporte);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reporteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reporte>> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(reporteService.obtenerPorUsuario(usuarioId));
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Reporte>> obtenerPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(reporteService.obtenerPorCategoria(categoriaId));
    }

    @GetMapping("/estado/{estadoId}")
    public ResponseEntity<List<Reporte>> obtenerPorEstado(@PathVariable Long estadoId) {
        return ResponseEntity.ok(reporteService.obtenerPorEstado(estadoId));
    }
}