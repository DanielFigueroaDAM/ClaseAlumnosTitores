package org.example.service;

import org.example.model.Titor;
import org.example.repository.TitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class TitorService {
    private final TitorRepository TitorRepository;

    @Autowired
    public TitorService(TitorRepository TitorRepository) {
        this.TitorRepository = TitorRepository;
    }
    @Transactional
    public Titor crearOuActualizarTitor(Titor Titor) {
        return TitorRepository.save(Titor);
    }

    @Transactional
    public void eliminarTitor(Long id) {
        TitorRepository.deleteById(id);
    }

    public List<Titor> listarTitors() {
        return TitorRepository.findAll();
    }
    public Optional<Titor> obtenerTitorPorId(Long id) {
        return TitorRepository.findById(id);
    }
}
