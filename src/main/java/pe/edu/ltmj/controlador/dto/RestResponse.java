package pe.edu.ltmj.controlador.dto;

public class RestResponse<T> {
    private T data;
    private String mensaje;
    public RestResponse() {
        this(null, "");
    }

    public RestResponse(T data, String mensaje) {
        this.data = data;
        this.mensaje = mensaje;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
