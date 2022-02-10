package com.example.demo.tripbookingapi.configs;

import com.example.demo.tripbookingapi.security.JwtGrantedAuthoritiesConverter;
import com.example.demo.tripbookingapi.utils.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .authorizeRequests(authorize -> authorize
            // TODO .antMatchers("/", "/swagger-ui/**").hasRole(Roles.SWAGGER_UI)
            .antMatchers("/v1/types").hasRole(Roles.SWAGGER_UI)
            .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
            .antMatchers("/actuator/health").permitAll()
            .anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt().jwtAuthenticationConverter(jwtAuthenticationConverter()));
  }

  @Bean
  public JwtAuthenticationConverter jwtAuthenticationConverter() {
    final var jwtAuthenticationConverter = new JwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new JwtGrantedAuthoritiesConverter());
    return jwtAuthenticationConverter;
  }
}
