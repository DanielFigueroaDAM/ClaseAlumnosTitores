package org.example.service;

import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
    @Transactional
    public Alumno crearOuActualizarAlumno(Alumno alumno) {
        if (alumno.getTitor() != null && alumno.getTitor().getId() != null) {
            Titor t = new Titor();
            t.setId(alumno.getTitor().getId());
            alumno.setTitor(t); // asigna el t con solo id (mejor cargar el Titor gestionado desde la BD)
        }
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
