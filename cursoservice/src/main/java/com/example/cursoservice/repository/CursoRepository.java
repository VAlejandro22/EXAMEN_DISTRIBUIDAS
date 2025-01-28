package com.example.cursoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cursoservice.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
