package pe.edu.ltmj.repositorio.mapper;

import pe.edu.ltmj.entidad.Encuesta;

public interface EncuestaMapper {

    Encuesta obtenerEncuestaPorId(Long id);
    void registrarEncuesta(Encuesta encuesta);
}
