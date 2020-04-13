package pe.edu.ltmj.repositorio;

import pe.edu.ltmj.entidad.Encuesta;

public interface EncuestaRepositorio {

    Encuesta obtenerPorId(Long id);
    Encuesta crearEncuesta(Encuesta nuevaEncuesta);
}
