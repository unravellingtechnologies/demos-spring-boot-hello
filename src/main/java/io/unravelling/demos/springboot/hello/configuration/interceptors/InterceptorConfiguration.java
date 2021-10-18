package io.unravelling.demos.springboot.hello.configuration.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class InterceptorConfiguration extends WebMvcConfigurationSupport {

  private final ControllerInterceptor controllerInterceptor;

  public InterceptorConfiguration(ControllerInterceptor controllerInterceptor) {
    this.controllerInterceptor = controllerInterceptor;
  }

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(controllerInterceptor);
  }
}
