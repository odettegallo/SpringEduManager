package com.alkemy.edumanager.service;

import com.alkemy.edumanager.model.Curso;
import java.util.List;

public interface CursoService {
    List<Curso> obtenerTodos();
    Curso guardar(Curso curso);
    Curso obtenerPorId(Long id);
    void eliminar(Long id);
}