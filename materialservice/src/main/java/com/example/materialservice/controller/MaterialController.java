package com.example.materialservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.materialservice.entity.Material;
import com.example.materialservice.repository.MaterialRepository;

import java.util.List;

@RestController
@RequestMapping("/materiales")
public class MaterialController {
    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public List<Material> listarMateriales() {
        return materialRepository.findAll();
    }

    @PostMapping
    public Material crearMaterial(@RequestBody Material material) {
        return materialRepository.save(material);
    }

    @GetMapping("/{id}")
    public Material obtenerMaterial(@PathVariable Long id) {
        return materialRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarMaterial(@PathVariable Long id) {
        materialRepository.deleteById(id);
    }
}
