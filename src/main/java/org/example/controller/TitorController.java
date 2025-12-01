package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Titor;
import org.example.repository.TitorRepository;
import org.example.service.TitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public class TitorController {
    @Autowired
    private TitorRepository TitorRepository;
    @Autowired
    private TitorService TitorService;

    @Operation(summary = "Método que crea Titor")
    @PostMapping("/titor")
    public Titor crearTitor(Titor Titor) {
        return TitorService.crearOuActualizarTitor(Titor);
    }
    @Operation(summary = "Método que elimina Titor")
    @PostMapping("/eliminar/{id}")
    public void eliminarTitor(Long id) {
        TitorService.eliminarTitor(id);
    }

    @Operation(summary = "Listar Titors")
    @GetMapping("/listar")
    public List<Titor> listarTitors() {
        return TitorService.listarTitors();
    }

    @Operation(summary = "Obter Titor por ID")
    @GetMapping("/obter/{id}")
    public ResponseEntity<Titor> obterTitorPorId(Long id) { // preguntar porq se retonra un responseEntity
        Optional<Titor> Titor = TitorService.obtenerTitorPorId(id);
        return Titor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); //preguntar tambien esto
    }

}
