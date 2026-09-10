package com.alkemy.edumanager.service;


import com.alkemy.edumanager.model.Estudiante;
import java.util.List;

public interface EstudianteService {
    List<Estudiante> obtenerTodos();
    Estudiante guardar(Estudiante estudiante);
    Estudiante obtenerPorId(Long id);
    void eliminar(Long id);
}
