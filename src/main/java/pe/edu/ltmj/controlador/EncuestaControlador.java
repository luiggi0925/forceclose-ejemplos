package pe.edu.ltmj.controlador;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.ltmj.controlador.dto.NuevaEncuestaDto;
import pe.edu.ltmj.controlador.dto.RestResponse;
import pe.edu.ltmj.entidad.Encuesta;
import pe.edu.ltmj.servicio.EncuestaServicio;

import java.util.List;

@RestController
@RequestMapping(value = "/encuestas", consumes = MediaType.APPLICATION_JSON_VALUE)
public class EncuestaControlador {

    private final EncuestaServicio encuestaServicio;

    public EncuestaControlador(EncuestaServicio encuestaServicio) {
        this.encuestaServicio = encuestaServicio;
    }

    @GetMapping("/{id}")
    public RestResponse<Encuesta> obtenerEncuesta(@PathVariable("id") Long id) {
        return new RestResponse<>(encuestaServicio.obtenerPorId(id), "OK");
    }

    @PostMapping
    public RestResponse<Encuesta> crearEncuesta(@RequestBody NuevaEncuestaDto nuevaEncuesta) {
        return new RestResponse<>(encuestaServicio.crearEncuesta(nuevaEncuesta), "OK");
    }
}
