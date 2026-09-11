package com.alkemy.edumanager.controller;

import com.alkemy.edumanager.model.Evaluacion;
import com.alkemy.edumanager.repository.CursoRepository;
import com.alkemy.edumanager.repository.EstudianteRepository;
import com.alkemy.edumanager.repository.EvaluacionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    private final EvaluacionRepository evaluacionRepository;
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public EvaluacionController(EvaluacionRepository evaluacionRepository,
                                EstudianteRepository estudianteRepository,
                                CursoRepository cursoRepository) {
        this.evaluacionRepository = evaluacionRepository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public String listarEvaluaciones(Model model) {
        model.addAttribute("evaluaciones", evaluacionRepository.findAll());
        return "evaluaciones/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("evaluacion", new Evaluacion());
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        model.addAttribute("cursos", cursoRepository.findAll());
        return "evaluaciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEvaluacion(@ModelAttribute Evaluacion evaluacion) {
        evaluacionRepository.save(evaluacion);
        return "redirect:/evaluaciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Evaluacion evaluacion = evaluacionRepository.findById(id).orElse(null);
        model.addAttribute("evaluacion", evaluacion);
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        model.addAttribute("cursos", cursoRepository.findAll());
        return "evaluaciones/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvaluacion(@PathVariable Long id) {
        evaluacionRepository.deleteById(id);
        return "redirect:/evaluaciones";
    }
}