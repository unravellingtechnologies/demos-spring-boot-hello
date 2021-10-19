package io.unravelling.demos.springboot.hello.configuration.interceptors;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import io.unravelling.logging.memoryappender.MemoryAppender;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerInterceptorTest {

  private ControllerInterceptor controllerInterceptor;

  private MockHttpServletRequest request;

  @Mock
  private MockHttpServletResponse response;

  private static MemoryAppender appender;

  @Mock
  private Object handler;

  @BeforeAll
  void setup() {
    controllerInterceptor = new ControllerInterceptor();
    request = new MockHttpServletRequest();
    request.addHeader("Content-Type", "application/json");
    request.addHeader("envoy-retry-count", "0");
    request.setRequestURI("/api/v1/test");

    Logger logger = (Logger) LoggerFactory.getLogger(ControllerInterceptor.class);

    // Create and start a ListAppender
    appender = new MemoryAppender();
    appender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
    appender.start();

    // Add the appender to the logger
    logger.addAppender(appender);
  }

  @Test
  void preHandle() {
    controllerInterceptor.preHandle(request, response, handler);
    assertTrue(appender.contains("Received request on /api/v1/test"));
    assertTrue(appender.contains("Http headers"));
    assertTrue(appender.contains("Content-Type: application/json"));
    assertThat(appender.getAllEvents()).hasSize(4);
    assertThat(appender.search(Level.INFO)).hasSize(4);
  }

  @AfterAll
  void tearDown() {
    appender.stop();
  }
}
