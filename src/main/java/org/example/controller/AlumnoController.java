package org.example.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Alumno;
import org.example.repository.AlumnoRepository;
import org.example.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AlumnoController.MAPPING)
public class AlumnoController {

    public static final String MAPPING = "/baseAlumno";
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AlumnoService alumnoService;

    @Operation(summary = "Método que crea alumno")
    @PostMapping("/alumno")
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.crearOuActualizarAlumno(alumno);
    }
    @Operation(summary = "Método que elimina alumno")
    @PostMapping("/eliminar/{id}")
    public void eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
    }

    @Operation(summary = "Listar alumnos")
    @GetMapping("/listar")
    public List<Alumno> listarAlumnos() {
        return alumnoService.listarAlumnos();
    }

    @Operation(summary = "Obter alumno por ID")
    @GetMapping("/obter/{id}")
    public ResponseEntity<Alumno> obterAlumnoPorId(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.obtenerAlumnoPorId(id);
        return alumno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Listar alumnos por Titor ID")
    @GetMapping("/listarPorTitor/{titorId}")
    public List<Alumno> listarAlumnosPorTitorId(@PathVariable Long titorId) {
        return alumnoRepository.findByTitorId(titorId);
    }

}
