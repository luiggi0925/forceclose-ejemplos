package pe.edu.ltmj.servicio;

import org.springframework.stereotype.Service;
import pe.edu.ltmj.controlador.dto.NuevaEncuestaDto;
import pe.edu.ltmj.entidad.Encuesta;
import pe.edu.ltmj.entidad.Pregunta;
import pe.edu.ltmj.excepcion.NotFoundException;
import pe.edu.ltmj.repositorio.EncuestaRepositorio;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class EncuestaServicioImpl implements EncuestaServicio {

    private final EncuestaRepositorio encuestaRepositorio;

    public EncuestaServicioImpl(EncuestaRepositorio encuestaRepositorio) {
        this.encuestaRepositorio = encuestaRepositorio;
    }

    @Override
    public Encuesta obtenerPorId(Long id) {
        if (id <= 0) throw new IllegalArgumentException("Id no puede ser negativo");
        Encuesta encuesta = encuestaRepositorio.obtenerPorId(id);
        if (encuesta == null) throw new NotFoundException("No existe encuesta con id " + id, 404);
        return encuesta;
    }

    @Override
    public Encuesta crearEncuesta(NuevaEncuestaDto nuevaEncuestaDto) {
        Encuesta encuesta = new Encuesta();
        encuesta.setTitulo(nuevaEncuestaDto.getTitulo());
        encuesta.setPreguntas(nuevaEncuestaDto.getPreguntas().stream()
        .map(textoPregunta -> {
            Pregunta pregunta = new Pregunta();
            pregunta.setTexto(textoPregunta);
            return pregunta;
        }).collect(toList()));
        return encuestaRepositorio.crearEncuesta(encuesta);
    }
}
