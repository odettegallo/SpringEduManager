package com.alkemy.edumanager.service.impl;

import com.alkemy.edumanager.model.Curso;
import com.alkemy.edumanager.repository.CursoRepository;
import com.alkemy.edumanager.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}