package pe.edu.ltmj.entidad;

import java.util.List;

public class Encuesta {
    private Long id;
    private String titulo;
    private List<Pregunta> preguntas;
    private Integer habilitado;

    public Encuesta() {
        this.habilitado = 0;
    }

    public Encuesta(Long id, String titulo, List<Pregunta> preguntas) {
        this.id = id;
        this.titulo = titulo;
        this.preguntas = preguntas;
        this.habilitado = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Integer getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Integer habilitado) {
        this.habilitado = habilitado;
    }
}
