package com.example.cursoservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.cursoservice.dto.MaterialDTO;

@FeignClient(name = "materialservice", url = "http://localhost:8083")
public interface MaterialClient {
    @GetMapping("/materiales/{id}")
    MaterialDTO obtenerMaterial(@PathVariable Long id);
}
