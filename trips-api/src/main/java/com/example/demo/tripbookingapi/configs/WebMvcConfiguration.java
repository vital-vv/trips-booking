package com.example.demo.tripbookingapi.configs;

import com.example.demo.tripbookingapi.domain.enumeration.Language;
import com.example.demo.tripbookingapi.domain.enumeration.TripType;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(String.class, Language.class, source -> Language.valueOf(source.toUpperCase()));
    registry.addConverter(String.class, TripType.class, source -> TripType.valueOf(source.toUpperCase()));
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/v1/**").allowedOrigins("*");
  }
}
