package cl.duoc.jv0101.caso07.recetas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Recetas API")
                        .version("1.0.0")
                        .description("Microservicio Recetas del caso caso07 - MediCare."));
    }
}
