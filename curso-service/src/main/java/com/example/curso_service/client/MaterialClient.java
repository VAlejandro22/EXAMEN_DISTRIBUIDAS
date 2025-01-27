package com.example.curso_service.client;

import com.example.curso_service.data.MaterialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "material-service", url = "http://localhost:8081/api/materiales")
public interface MaterialClient {

    @GetMapping("/{id}")
    MaterialDTO obtenerMaterialPorId(@PathVariable Long id);
}
