package org.example.repository;

import org.example.model.Titor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TitorRepository extends JpaRepository<Titor, Long> {
}
