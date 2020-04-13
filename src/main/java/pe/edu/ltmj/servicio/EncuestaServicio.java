package pe.edu.ltmj.servicio;

import pe.edu.ltmj.controlador.dto.NuevaEncuestaDto;
import pe.edu.ltmj.entidad.Encuesta;

public interface EncuestaServicio {

    Encuesta obtenerPorId(Long id);
    Encuesta crearEncuesta(NuevaEncuestaDto nuevaEncuestaDto);
}
