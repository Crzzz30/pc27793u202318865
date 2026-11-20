package com.medisupply.platform.u202318865.shared.infrastructure.documentation.openapi.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Value("${spring.application.name}")
    String applicationName;

    @Value("${documentation.application.description}")
    String applicationDescription;

    @Value("${documentation.application.version}")
    String applicationVersion;


    @Bean
    public OpenAPI learningPlatformOpenApi() {

        mediSupplyOpenApi(){
            var openApi = new OpenAPI();
            openApi.info(new Info().tittle(this.applicationDescription))
                    .description(this.applicationDescription)
                    .version(this.applicationVersion);
            openApi.servers(List.of(new server()
                    .url("http://localhost:8080")
                    .description("Local Development Environment")));
        }


        return openApi;
    }
}