package pe.edu.ltmj;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import pe.edu.ltmj.controlador.EncuestaControlador;
import pe.edu.ltmj.controlador.dto.NuevaEncuestaDto;
import pe.edu.ltmj.controlador.dto.RestResponse;
import pe.edu.ltmj.entidad.Encuesta;

import java.util.Arrays;

@Configuration
@ComponentScan
public class Aplicacion {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Aplicacion.class)) {
            EncuestaControlador controlador = ctx.getBean(EncuestaControlador.class);
            NuevaEncuestaDto nuevaEncuestaDto = new NuevaEncuestaDto();
            nuevaEncuestaDto.setTitulo("lol");
            nuevaEncuestaDto.setPreguntas(Arrays.asList("pregunta1", "pregunta2"));
            RestResponse<Encuesta> respuestaEncuesta = controlador.crearEncuesta(nuevaEncuestaDto);
            System.out.println(respuestaEncuesta.getData().getId());
            System.out.println(respuestaEncuesta.getData().getTitulo());
        }
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return new Jackson2ObjectMapperBuilder()
//                .indentOutput(true)
//                .serializationInclusion(JsonInclude.Include.NON_NULL)
//                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .build();
    }

    @Bean
    public ContentNegotiationManagerFactoryBean contentNegotiationManager() {
        ContentNegotiationManagerFactoryBean manager = new ContentNegotiationManagerFactoryBean();
        manager.setFavorPathExtension(true);
        manager.setFavorParameter(false);
        manager.setParameterName("mediaType");
        manager.setIgnoreAcceptHeader(false);
        manager.setUseRegisteredExtensionsOnly(true);
        manager.setDefaultContentType(MediaType.APPLICATION_JSON);
        manager.addMediaType("json", MediaType.APPLICATION_JSON);
        return manager;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.setMessageConverters(Arrays.asList(jsonMessageConverter()));
        return adapter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter jsonMessageConverter() {
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper());
        return jsonMessageConverter;
    }
}
