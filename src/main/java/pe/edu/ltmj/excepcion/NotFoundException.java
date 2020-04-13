package pe.edu.ltmj.excepcion;

public class NotFoundException extends BaseException {
    public NotFoundException(int codigoError) {
        super(codigoError);
    }

    public NotFoundException(String message, int codigoError) {
        super(message, codigoError);
    }

    public NotFoundException(String message, Throwable cause, int codigoError) {
        super(message, cause, codigoError);
    }

    public NotFoundException(Throwable cause, int codigoError) {
        super(cause, codigoError);
    }
}
