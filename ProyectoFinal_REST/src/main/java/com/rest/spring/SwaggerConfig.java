package com.rest.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2) 
           .apiInfo(getApiInfo())
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())
          .build();                                           
    }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("swagger-ui.html")
       .addResourceLocations("classpath:/META-INF/resources/");

       registry.addResourceHandler("/webjars/**")
       .addResourceLocations("classpath:/META-INF/resources/webjars/");
   }
   
   private ApiInfo getApiInfo() {
       return new ApiInfoBuilder()
               .title("Servicio REST del Proyecto Final JavaGoesGreen©")
               .version("1.0")
               .license("Spain Generation License 2.0")
               .description("Aplicación del Proyecto Final encargada de consultar la BBDD y enviar información en JSON")
               .build();
   }
}
//http://localhost:5000/swagger-ui.html#/ DOCUMENTACION UI
//http://localhost:5000/v2/api-docs   DOCUMENTACION JSON

