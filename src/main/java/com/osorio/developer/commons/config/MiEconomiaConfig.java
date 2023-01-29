package com.osorio.developer.commons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiEconomiaConfig {

    /**
     * <p>
     *     Bean encargado de configurar el CORS para todas las request mapping.
     *     Sólo es para el ambiente local.
     * </p>
     */

    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**");
            }
        };
    }


}
