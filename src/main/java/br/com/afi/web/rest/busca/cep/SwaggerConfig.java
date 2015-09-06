package br.com.afi.web.rest.busca.cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * Configuração do Swagger para a aplicação.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@Configuration
@EnableSwagger
@EnableAutoConfiguration
public class SwaggerConfig {
    
    private SpringSwaggerConfig springSwaggerConfig;
 
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }
    
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(new ApiInfo(
                        "API para busca de CEPs",
                        null,
                        null,
                        "ignacio83@gmail.com",
                        null,
                        null
                ))
                .useDefaultResponseMessages(false)
                //Map the specific URL patterns into Swagger
                .includePatterns("/endereco/.*");
    }
    
}
