package com.alkemy.edumanager.service.impl;


import com.alkemy.edumanager.model.Estudiante;
import com.alkemy.edumanager.repository.EstudianteRepository;
import com.alkemy.edumanager.service.EstudianteService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtenerPorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
