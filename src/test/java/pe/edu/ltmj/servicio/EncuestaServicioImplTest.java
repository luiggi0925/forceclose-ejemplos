package pe.edu.ltmj.servicio;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pe.edu.ltmj.controlador.dto.NuevaEncuestaDto;
import pe.edu.ltmj.entidad.Encuesta;
import pe.edu.ltmj.entidad.Pregunta;
import pe.edu.ltmj.excepcion.NotFoundException;
import pe.edu.ltmj.repositorio.EncuestaRepositorio;
import pe.edu.ltmj.repositorio.PreguntaRepositorio;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;

public class EncuestaServicioImplTest {

    private EncuestaServicioImpl encuestaServicio;
    private EncuestaRepositorio encuestaRepositorio;
    private PreguntaRepositorio preguntaRepositorio;

    @Before
    public void init() {
        encuestaRepositorio = mock(EncuestaRepositorio.class);
        preguntaRepositorio = mock(PreguntaRepositorio.class);
        encuestaServicio = new EncuestaServicioImpl(encuestaRepositorio, preguntaRepositorio);
    }

    @Test
    public void obtenerPorIdTest() {
        Encuesta encuesta = new Encuesta(1L, "satisfacción de cliente",
                asList(new Pregunta(1L, "pregunta 1", 1L)));
        doReturn(encuesta).when(encuestaRepositorio).obtenerPorId(1L);

        Encuesta obtenido = encuestaServicio.obtenerPorId(1L);
        assertThat(obtenido.getId(), equalTo(encuesta.getId()));
        assertThat(obtenido.getTitulo(), equalTo(encuesta.getTitulo()));
        assertThat(obtenido.getPreguntas().get(0).getTexto(), equalTo(encuesta.getPreguntas().get(0).getTexto()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void obtenerPorIdZeroTest() {
        encuestaServicio.obtenerPorId(0L);
    }

    @Test
    public void obtenerPorIdNullResultTest() {
        doReturn(null).when(encuestaRepositorio).obtenerPorId(1L);

        NotFoundException nfe = Assert.assertThrows(NotFoundException.class, () -> encuestaServicio.obtenerPorId(1L));
        assertThat(nfe.getMessage(), Matchers.containsString("id 1"));
    }

    @Test
    public void crearEncuestaTest() {
        final Long id = 10L;
        doAnswer( invocationOnMock -> {
            Encuesta encuesta = invocationOnMock.getArgument(0, Encuesta.class);
            encuesta.setId(id);
            return encuesta;
        }).when(encuestaRepositorio).crearEncuesta(any());
        doAnswer( invocation -> invocation.getArgument(0, Pregunta.class))
                .when(preguntaRepositorio).crearPregunta(any());

        NuevaEncuestaDto nuevaEncuestaDto = new NuevaEncuestaDto();
        nuevaEncuestaDto.setTitulo("hola mundo");
        nuevaEncuestaDto.setPreguntas(asList("p1", "p2"));

        Encuesta encuesta = encuestaServicio.crearEncuesta(nuevaEncuestaDto);
        assertThat(encuesta.getId(), equalTo(id));
        assertThat(encuesta.getTitulo(), equalTo("hola mundo"));
        assertThat(encuesta.getPreguntas(), contains(
                allOf(
                        hasProperty("texto", equalTo("p1")),
                        hasProperty("idEncuesta", equalTo(id))
                ),
                allOf(
                        hasProperty("texto", equalTo("p2")),
                        hasProperty("idEncuesta", equalTo(id))
                )
        ));
    }
}
