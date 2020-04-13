package pe.edu.ltmj.entidad;

public class RespuestaPregunta {
    private Long id;
    private String respuesta;
    private Boolean correcta;

    public RespuestaPregunta() {
    }

    public RespuestaPregunta(Long id, String respuesta, Boolean correcta) {
        this.id = id;
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }
}
