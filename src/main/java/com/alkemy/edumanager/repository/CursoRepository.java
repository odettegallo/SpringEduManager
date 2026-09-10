package com.alkemy.edumanager.repository;


import com.alkemy.edumanager.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
