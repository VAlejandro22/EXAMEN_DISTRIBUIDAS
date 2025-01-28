package com.example.cursoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cursoservice.entity.Curso;
import com.example.cursoservice.entity.CursoMaterial;
import com.example.cursoservice.repository.CursoRepository;
import com.example.cursoservice.repository.CursoMaterialRepository;
import com.example.cursoservice.client.MaterialClient;
import com.example.cursoservice.dto.MaterialDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMaterialRepository cursoMaterialRepository;

    @Autowired
    private MaterialClient materialClient;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PostMapping("/{cursoId}/materiales/{materialId}")
    public CursoMaterial asignarMaterialACurso(@PathVariable Long cursoId, @PathVariable Long materialId) {
        CursoMaterial cursoMaterial = new CursoMaterial();
        cursoMaterial.setCursoId(cursoId);
        cursoMaterial.setMaterialId(materialId);
        return cursoMaterialRepository.save(cursoMaterial);
    }

    @GetMapping("/{cursoId}/materiales")
    public List<MaterialDTO> listarMaterialesDeCurso(@PathVariable Long cursoId) {
        List<CursoMaterial> cursoMateriales = cursoMaterialRepository.findByCursoId(cursoId);
        return cursoMateriales.stream()
                .map(cm -> materialClient.obtenerMaterial(cm.getMaterialId()))
                .collect(Collectors.toList());
    }

    @GetMapping("/materiales/{materialId}/cursos")
    public List<Curso> listarCursosQueUsanMaterial(@PathVariable Long materialId) {
        List<CursoMaterial> cursoMateriales = cursoMaterialRepository.findByMaterialId(materialId);
        List<Long> cursoIds = cursoMateriales.stream()
                .map(CursoMaterial::getCursoId)
                .collect(Collectors.toList());
        return cursoRepository.findAllById(cursoIds);
    }

    @DeleteMapping("/{cursoId}/materiales/{materialId}")
    public void eliminarMaterialDeCurso(@PathVariable Long cursoId, @PathVariable Long materialId) {
        cursoMaterialRepository.deleteByCursoIdAndMaterialId(cursoId, materialId);
    }
}
