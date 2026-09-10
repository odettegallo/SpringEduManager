package com.alkemy.edumanager.repository;


import com.alkemy.edumanager.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
