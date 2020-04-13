package pe.edu.ltmj.servicio;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.ltmj.controlador.dto.NuevaEncuestaDto;
import pe.edu.ltmj.entidad.Encuesta;
import pe.edu.ltmj.entidad.Pregunta;
import pe.edu.ltmj.excepcion.NotFoundException;
import pe.edu.ltmj.repositorio.EncuestaRepositorio;
import pe.edu.ltmj.repositorio.PreguntaRepositorio;

import static java.util.stream.Collectors.toList;

@Service
public class EncuestaServicioImpl implements EncuestaServicio {

    private final EncuestaRepositorio encuestaRepositorio;
    private final PreguntaRepositorio preguntaRepositorio;

    public EncuestaServicioImpl(EncuestaRepositorio encuestaRepositorio, PreguntaRepositorio preguntaRepositorio) {
        this.encuestaRepositorio = encuestaRepositorio;
        this.preguntaRepositorio = preguntaRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public Encuesta obtenerPorId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id no puede ser negativo o cero");
        }
        Encuesta encuesta = encuestaRepositorio.obtenerPorId(id);
        if (encuesta == null) {
            throw new NotFoundException("No existe encuesta con id " + id, 404);
        }
        return encuesta;
    }

    @Override
    @Transactional
    public Encuesta crearEncuesta(NuevaEncuestaDto nuevaEncuestaDto) {
        Encuesta encuesta = new Encuesta();
        encuesta.setTitulo(nuevaEncuestaDto.getTitulo());
        encuesta.setPreguntas(nuevaEncuestaDto.getPreguntas().stream()
        .map(textoPregunta -> {
            Pregunta pregunta = new Pregunta();
            pregunta.setTexto(textoPregunta);
            return pregunta;
        }).collect(toList()));
        encuestaRepositorio.crearEncuesta(encuesta);
        encuesta.getPreguntas().forEach(pregunta -> {
            pregunta.setIdEncuesta(encuesta.getId());
            preguntaRepositorio.crearPregunta(pregunta);
        });
        return encuesta;
    }
}
