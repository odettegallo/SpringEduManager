package com.alkemy.edumanager.config;

import com.alkemy.edumanager.model.Curso;
import com.alkemy.edumanager.model.Estudiante;
import com.alkemy.edumanager.model.Evaluacion;
import com.alkemy.edumanager.repository.CursoRepository;
import com.alkemy.edumanager.repository.EstudianteRepository;
import com.alkemy.edumanager.repository.EvaluacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;
    private final EvaluacionRepository evaluacionRepository;

    public DataLoader(EstudianteRepository estudianteRepository, 
                      CursoRepository cursoRepository, 
                      EvaluacionRepository evaluacionRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public void run(String... args) {
        // Estudiante cuyo email coincide con el login del usuario estandar
        Estudiante est1 = estudianteRepository.save(new Estudiante("Estudiante", "Prueba", "estudiante"));

        Curso c1 = cursoRepository.save(new Curso("Java Spring Boot", "Desarrollo web backend con Spring"));
        Curso c2 = cursoRepository.save(new Curso("Bases de Datos SQL", "Modelado y consultas relacionales"));

        evaluacionRepository.save(new Evaluacion(6.5, 7.0, 6.8, est1, c1));
        evaluacionRepository.save(new Evaluacion(5.0, 6.0, 5.5, est1, c2));
    }
}