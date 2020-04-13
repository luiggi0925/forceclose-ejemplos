package pe.edu.ltmj.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.edu.ltmj.controlador.dto.RestExceptionResponse;
import pe.edu.ltmj.excepcion.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestExceptionResponse> handleNotFound(NotFoundException ex) {
        RestExceptionResponse restExceptionResponse = new RestExceptionResponse();
        restExceptionResponse.setCodigoError(ex.getCodigoError());
        restExceptionResponse.setMensaje(ex.getMessage());
        return new ResponseEntity<>(restExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RestExceptionResponse> handleNotFound(IllegalArgumentException ex) {
        RestExceptionResponse restExceptionResponse = new RestExceptionResponse();
        restExceptionResponse.setCodigoError(400);
        restExceptionResponse.setMensaje(ex.getMessage());
        return new ResponseEntity<>(restExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
