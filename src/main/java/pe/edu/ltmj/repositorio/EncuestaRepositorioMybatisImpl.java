package pe.edu.ltmj.repositorio;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pe.edu.ltmj.entidad.Encuesta;
import pe.edu.ltmj.repositorio.mapper.EncuestaMapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Primary
public class EncuestaRepositorioMybatisImpl implements EncuestaRepositorio {

    private final EncuestaMapper encuestaMapper;

    public EncuestaRepositorioMybatisImpl(EncuestaMapper encuestaMapper) {
        this.encuestaMapper = encuestaMapper;
    }

    @Override
    public Encuesta obtenerPorId(Long id) {
        return encuestaMapper.obtenerEncuestaPorId(id);
    }

    @Override
    public Encuesta crearEncuesta(Encuesta nuevaEncuesta) {
        encuestaMapper.registrarEncuesta(nuevaEncuesta);
        return nuevaEncuesta;
    }
}
