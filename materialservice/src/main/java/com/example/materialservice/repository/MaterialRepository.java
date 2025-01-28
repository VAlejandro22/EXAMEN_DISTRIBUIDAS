package com.example.materialservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.materialservice.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
