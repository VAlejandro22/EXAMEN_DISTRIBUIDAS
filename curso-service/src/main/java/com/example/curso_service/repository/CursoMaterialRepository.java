package com.example.curso_service.repository;


import com.example.curso_service.model.CursoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoMaterialRepository extends JpaRepository<CursoMaterial, Long> {
    List<CursoMaterial> findByCursoId(Long cursoId);
    List<CursoMaterial> findByMaterialId(Long materialId);
    Optional<CursoMaterial> findByCursoIdAndMaterialId(Long cursoId, Long playerId);
}