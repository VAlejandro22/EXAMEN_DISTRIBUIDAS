package com.example.cursoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cursoservice.entity.CursoMaterial;

import java.util.List;

public interface CursoMaterialRepository extends JpaRepository<CursoMaterial, Long> {
    List<CursoMaterial> findByCursoId(Long cursoId);
    List<CursoMaterial> findByMaterialId(Long materialId);
    void deleteByCursoIdAndMaterialId(Long cursoId, Long materialId);
}
