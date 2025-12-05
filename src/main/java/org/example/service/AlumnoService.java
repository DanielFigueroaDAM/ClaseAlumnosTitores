package org.example.service;

import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.AlumnoRepository;
import org.example.repository.TitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final TitorRepository titorRepository;
    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository, TitorRepository titorRepository) {
        this.alumnoRepository = alumnoRepository;
        this.titorRepository = titorRepository;
    }
    @Transactional
    public Alumno crearOuActualizarAlumno(Alumno alumno) {
        if (alumno.getTitor() == null || alumno.getTitor().getId() == null) {
            throw new RuntimeException("Alumno debe tener un Titor asignado");
        }

        // Buscar Titor existente
        Titor titor = titorRepository.findById(alumno.getTitor().getId())
                .orElseThrow(() -> new RuntimeException(
                        "Titor no encontrado con ID: " + alumno.getTitor().getId()
                ));

        alumno.setTitor(titor);
        return alumnoRepository.save(alumno);
    }

    @Transactional
    public void eliminarAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }
    public Optional<Alumno> obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id);
    }
}
