package io.unravelling.demos.springboot.hello.configuration.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ControllerInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    logger.info("Received request on {}", request.getRequestURI());
    logger.info("Http headers:");
    request.getHeaderNames().asIterator().forEachRemaining(
        header -> logger.info("\t{}: {}", header, request.getHeader(header))
    );
    return true;
  }
}
