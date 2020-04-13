package pe.edu.ltmj.controlador.dto;

public class RestExceptionResponse {
    private String mensaje;
    private int codigoError;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }
}
