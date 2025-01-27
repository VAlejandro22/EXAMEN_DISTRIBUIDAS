package com.example.curso_service.service;

import com.example.curso_service.client.MaterialClient;
import com.example.curso_service.data.MaterialDTO;
import com.example.curso_service.model.Curso;
import com.example.curso_service.model.CursoMaterial;
import com.example.curso_service.repository.CursoMaterialRepository;
import com.example.curso_service.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final CursoMaterialRepository cursoMaterialRepository;
    private final MaterialClient materialClient;

    public CursoService(CursoRepository cursoRepository, CursoMaterialRepository cursoMaterialRepository, MaterialClient materialClient) {
        this.cursoRepository = cursoRepository;
        this.cursoMaterialRepository = cursoMaterialRepository;
        this.materialClient = materialClient;
    }


    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }



    public void asignarMaterial(Long cursoId, Long materialId) {
        // Verificar existencia del curso
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Obtener material desde el microservicio de Material
        MaterialDTO materialDTO = materialClient.obtenerMaterialPorId(materialId);

        // Crear la relación CursoMaterial
        CursoMaterial cursoMaterial = new CursoMaterial();
        cursoMaterial.setCurso(curso);
        cursoMaterial.setMaterialId(materialDTO.getId());
        cursoMaterialRepository.save(cursoMaterial);
    }


    public List<CursoMaterial> listarMaterialesDeCurso(Long cursoId) {
        return cursoMaterialRepository.findByCursoId(cursoId);
    }

    public List<CursoMaterial> listarCursosDeMaterial(Long materialId) {
        return cursoMaterialRepository.findByMaterialId(materialId);
    }

    public void eliminarMaterialDeCurso(Long cursoMaterialId) {
        cursoMaterialRepository.deleteById(cursoMaterialId);
    }
}