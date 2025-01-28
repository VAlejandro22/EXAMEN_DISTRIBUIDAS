package com.example.curso_service.service;

import com.example.curso_service.client.MaterialClient;
import com.example.curso_service.data.MaterialDTO;
import com.example.curso_service.model.Curso;
import com.example.curso_service.model.CursoMaterial;
import com.example.curso_service.model.Material;
import com.example.curso_service.repository.CursoMaterialRepository;
import com.example.curso_service.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private  CursoRepository cursoRepository;
    @Autowired
    private  CursoMaterialRepository cursoMaterialRepository;
    @Autowired
    private  MaterialClient materialClient;




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
        materialClient.obtenerMaterialPorId(materialId);

        // Crear la relación CursoMaterial
        CursoMaterial cursoMaterial = new CursoMaterial();
        cursoMaterial.setCurso(curso);
        cursoMaterial.setMaterialId(materialId);
        cursoMaterialRepository.save(cursoMaterial);
    }


    public List<Material> listarMaterialesDeCurso(Long cursoId) {

        List<CursoMaterial> cursoMateriales = cursoMaterialRepository.findByCursoId(cursoId);
        List<Material> materiales = new ArrayList<>();
        for(CursoMaterial cursoMaterial : cursoMateriales){
            Long materialID = cursoMaterial.getMaterialId();
            Material material = materialClient.obtenerMaterialPorId(materialID).getBody();
            if(material != null){
                materiales.add(material);
            }
        }
        return materiales;
//        return cursoMaterialRepository.findByCursoId(cursoId);
    }

    public List<Curso> listarCursosDeMaterial(Long materialId) {
        List<CursoMaterial> cursoMateriales = cursoMaterialRepository.findByMaterialId(materialId);
        List<Curso> cursos = new ArrayList<>();

        for(CursoMaterial cursoMaterial : cursoMateriales){
            cursos.add(cursoMaterial.getCurso());
        }
        return cursos;
    }

    public void eliminarMaterialDeCurso(Long cursoId, Long materialId) {
        CursoMaterial cursoMaterial = cursoMaterialRepository.findByCursoIdAndMaterialId(cursoId,materialId).orElseThrow(()-> new RuntimeException("Material no encontrado en el curso"));
        cursoMaterialRepository.delete(cursoMaterial);
//
    }
}