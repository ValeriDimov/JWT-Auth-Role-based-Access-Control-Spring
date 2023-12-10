package bg.bestsurebet.server.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().
        info(new Info().
            title("Best SureBet API").
            version("1.0.0").
            contact(new Contact().name("Best SureBet Company").
                email("bestsurebet@abv.bg")).
            description("Best SureBet API"));
  }

}
