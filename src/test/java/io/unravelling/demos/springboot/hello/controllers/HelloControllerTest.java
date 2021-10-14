package io.unravelling.demos.springboot.hello.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

  @InjectMocks
  private HelloController helloController;

  @Test
  @DisplayName("greets without a name")
  void emptyGreet() {
    ResponseEntity<String> result = helloController.greet(null);
    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo("Hello there!");
  }

  @Test
  @DisplayName("greets with a name")
  void greetWithName() {
    String name = "Tiago";
    ResponseEntity<String> result = helloController.greet(name);
    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(String.format("Hello there, %s!", name));
  }

  @Test
  @DisplayName("fails with service unavailable")
  void serviceUnavailable() {
    ResponseEntity<String> result = helloController.serviceUnavailable();
    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
  }
}
