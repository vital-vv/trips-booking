package com.example.demo.tripbookingapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SecurityScheme(
    name = "keycloak",
    type = SecuritySchemeType.OPENIDCONNECT,
    in = SecuritySchemeIn.HEADER,
    openIdConnectUrl = "http://keycloak:8080/auth/realms/trips/.well-known/openid-configuration"
)
@OpenAPIDefinition(
    info = @Info(title = "Trips API", version = "1.0"),
    servers = @Server(url = "http://localhost:8080/trips-api", description = "Localhost dev environment"),
    security = @SecurityRequirement(name = "keycloak")
)
@SpringBootApplication
public class TripBookingApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(TripBookingApiApplication.class, args);
  }

}
