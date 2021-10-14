package io.unravelling.demos.springboot.hello.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloController {

  @GetMapping("/greet")
  public ResponseEntity<String> greet(@RequestParam(required = false) final String name) {
    String message = name != null && ! name.isEmpty() ? String.format("Hello there, %s!", name) : "Hello there!";
    return ResponseEntity.ok(message);
  }

  @GetMapping("/service-unavailable")
  public ResponseEntity<String> serviceUnavailable() {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
  }

}
