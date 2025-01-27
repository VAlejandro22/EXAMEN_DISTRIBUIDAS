package com.example.material_service.controller;



import com.example.material_service.model.Material;
import com.example.material_service.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping
    public ResponseEntity<Material> crearMaterial(@RequestBody Material material) {
        System.out.println("Material recibido: " + material);
        return ResponseEntity.ok(materialService.guardarMaterial(material));
    }

    @GetMapping
    public List<Material> listarMateriales() {
        return materialService.listarMateriales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> obtenerMaterialPorId(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.obtenerMaterialPorId(id));
    }
}
