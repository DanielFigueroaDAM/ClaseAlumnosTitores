package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import org.example.model.Titor;
import org.example.repository.TitorRepository;
import org.example.service.TitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(TitorController.MAPPING)
public class TitorController {

    public static final String MAPPING = "/baseTitor";

    @Autowired
    private TitorRepository TitorRepository;
    @Autowired
    private TitorService TitorService;

    @Operation(summary = "Método que crea Titor")
    @PostMapping("/titor")
    public Titor crearTitor(@RequestBody Titor titor) {
        return TitorService.crearOuActualizarTitor(titor);
    }
    @Operation(summary = "Método que elimina Titor")
    @PostMapping("/eliminar/{id}")
    public void eliminarTitor(@PathVariable Long id) {
        TitorService.eliminarTitor(id);
    }

    @Operation(summary = "Listar Titors")
    @GetMapping("/listar")
    public List<Titor> listarTitors() {
        return TitorService.listarTitors();
    }

    @Operation(summary = "Obter Titor por ID")
    @GetMapping("/obter/{id}")
    public ResponseEntity<Titor> obterTitorPorId(@PathVariable Long id) {
        Optional<Titor> Titor = TitorService.obtenerTitorPorId(id);
        return Titor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
