package pe.edu.ltmj.controlador.dto;

import java.util.List;

public class NuevaEncuestaDto {
    private String titulo;
    private List<String> preguntas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }
}
