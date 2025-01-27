package com.example.material_service.service;


import com.example.material_service.model.Material;
import com.example.material_service.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public Material guardarMaterial(Material material) {
        return materialRepository.save(material);
    }

    public List<Material> listarMateriales() {
        return materialRepository.findAll();
    }

    public Material obtenerMaterialPorId(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
    }
}
