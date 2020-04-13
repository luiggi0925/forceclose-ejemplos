package pe.edu.ltmj.repositorio;

import org.springframework.stereotype.Repository;
import pe.edu.ltmj.entidad.Encuesta;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EncuestaRepositorioMemoriaImpl implements EncuestaRepositorio {

    private final Map<Long, Encuesta> mapa;
    private final AtomicLong semilla;

    public EncuestaRepositorioMemoriaImpl() {
        this.mapa = new ConcurrentHashMap<>();
        this.semilla = new AtomicLong(1L);
    }

    @Override
    public Encuesta obtenerPorId(Long id) {
        return mapa.get(id);
    }

    @Override
    public Encuesta crearEncuesta(Encuesta nuevaEncuesta) {
        Long id = semilla.getAndIncrement();
        nuevaEncuesta.setId(id);
        mapa.put(id, nuevaEncuesta);
        return nuevaEncuesta;
    }
}
