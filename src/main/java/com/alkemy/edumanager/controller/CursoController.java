package com.alkemy.edumanager.controller;

import com.alkemy.edumanager.model.Curso;
import com.alkemy.edumanager.repository.EvaluacionRepository;
import com.alkemy.edumanager.service.CursoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;
    private final EvaluacionRepository evaluacionRepository;

    public CursoController(CursoService cursoService, EvaluacionRepository evaluacionRepository) {
        this.cursoService = cursoService;
        this.evaluacionRepository = evaluacionRepository;
    }

    @GetMapping
    public String listarCursos(Model model, Authentication authentication) {
        boolean esAdmin = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
        model.addAttribute("esAdmin", esAdmin);

        if (esAdmin) {
            model.addAttribute("cursos", cursoService.obtenerTodos());
        } else {
            model.addAttribute("evaluaciones", evaluacionRepository.findByEstudianteEmail(authentication.getName()));
        }
        return "cursos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("curso", new Curso());
        return "cursos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoService.guardar(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Curso curso = cursoService.obtenerPorId(id);
        model.addAttribute("curso", curso);
        return "cursos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Long id) {
        cursoService.eliminar(id);
        return "redirect:/cursos";
    }
}