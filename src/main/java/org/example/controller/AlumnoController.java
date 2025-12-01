package org.example.controller;


import org.example.repository.AlumnoRepository;
import org.example.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AlumnoService alumnoService;





}
