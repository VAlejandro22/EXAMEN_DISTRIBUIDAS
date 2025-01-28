package com.example.curso_service.controller;

import com.example.curso_service.model.Curso;
import com.example.curso_service.model.Material;
import com.example.curso_service.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.guardarCurso(curso));
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping("/{cursoId}/materiales/{materialId}")
    public ResponseEntity<String> asignarMaterial(@PathVariable Long cursoId, @PathVariable Long materialId) {
        cursoService.asignarMaterial(cursoId, materialId);
        return ResponseEntity.ok("Material asignado al curso");
    }

    @GetMapping("/{cursoId}/materiales")
    public ResponseEntity<List<Material>> listarMaterialesDeCurso(@PathVariable Long cursoId) {
        List<Material> materiales = cursoService.listarMaterialesDeCurso(cursoId);
        return ResponseEntity.ok(materiales);
    }

    @GetMapping("/materiales/{materialId}/cursos")
    public ResponseEntity<List<Curso>> listarCursosDeMaterial(@PathVariable Long materialId) {
        List<Curso> cursos = cursoService.listarCursosDeMaterial(materialId);
        return ResponseEntity.ok(cursos);
    }

    @DeleteMapping("/{cursoId}/materiales/{materialId}")
    public ResponseEntity<String> eliminarMaterialDeCurso(@PathVariable Long cursoId, @PathVariable Long materialId) {
        cursoService.eliminarMaterialDeCurso(cursoId, materialId);
        return ResponseEntity.ok("Material eliminado del curso");
    }
}
