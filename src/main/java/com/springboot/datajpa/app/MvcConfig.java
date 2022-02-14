package com.springboot.datajpa.app;

import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  private final Logger log = LoggerFactory.getLogger(getClass());

  /* Cargar imagenes desde un directorio del proyecto
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
    log.info("resourcePath: " + resourcePath);
    registry.addResourceHandler("/uploads/**")
        .addResourceLocations(resourcePath);
  }

   */
}
