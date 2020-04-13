package pe.edu.ltmj.entidad;

import java.util.List;

public class Pregunta {
    private Long id;
    private String texto;
    private Long idEncuesta;

    public Pregunta() {
    }

    public Pregunta(Long id, String texto, Long idEncuesta) {
        this.id = id;
        this.texto = texto;
        this.idEncuesta = idEncuesta;
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

    public Long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }
}
