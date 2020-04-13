package pe.edu.ltmj.entidad;

import java.util.List;

public class Pregunta {
    private Long id;
    private String texto;

    public Pregunta() {
    }

    public Pregunta(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
