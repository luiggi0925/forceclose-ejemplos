package pe.edu.ltmj.excepcion;

public class BaseException extends RuntimeException {
    protected final int codigoError;

    public BaseException(int codigoError) {
        this.codigoError = codigoError;
    }

    public BaseException(String message, int codigoError) {
        super(message);
        this.codigoError = codigoError;
    }

    public BaseException(String message, Throwable cause, int codigoError) {
        super(message, cause);
        this.codigoError = codigoError;
    }

    public BaseException(Throwable cause, int codigoError) {
        super(cause);
        this.codigoError = codigoError;
    }

    public int getCodigoError() {
        return codigoError;
    }
}
