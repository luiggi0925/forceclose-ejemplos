package pe.edu.ltmj.repositorio;

import org.springframework.stereotype.Repository;
import pe.edu.ltmj.entidad.Pregunta;
import pe.edu.ltmj.repositorio.mapper.PreguntaMapper;

@Repository
public class PreguntaRepositorioMybatisImpl implements PreguntaRepositorio {
    private final PreguntaMapper preguntaMapper;

    public PreguntaRepositorioMybatisImpl(PreguntaMapper preguntaMapper) {
        this.preguntaMapper = preguntaMapper;
    }

    @Override
    public Pregunta crearPregunta(Pregunta nuevaPregunta) {
        preguntaMapper.registrarPregunta(nuevaPregunta);
        return nuevaPregunta;
    }
}
