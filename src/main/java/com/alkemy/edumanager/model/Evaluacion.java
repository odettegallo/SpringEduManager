package com.alkemy.edumanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluaciones")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nota1;
    private Double nota2;
    private Double nota3;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Evaluacion() {}

    public Evaluacion(Double nota1, Double nota2, Double nota3, Estudiante estudiante, Curso curso) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Double getPromedio() {
        int count = 0;
        double sum = 0.0;
        if (nota1 != null) { sum += nota1; count++; }
        if (nota2 != null) { sum += nota2; count++; }
        if (nota3 != null) { sum += nota3; count++; }
        return count > 0 ? Math.round((sum / count) * 10.0) / 10.0 : 0.0;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getNota1() { return nota1; }
    public void setNota1(Double nota1) { this.nota1 = nota1; }
    public Double getNota2() { return nota2; }
    public void setNota2(Double nota2) { this.nota2 = nota2; }
    public Double getNota3() { return nota3; }
    public void setNota3(Double nota3) { this.nota3 = nota3; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}