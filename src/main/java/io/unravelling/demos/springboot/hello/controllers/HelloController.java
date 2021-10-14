package io.unravelling.demos.springboot.hello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
class HelloController {

  @GetMapping("/greet")
  ResponseEntity<String> greet(@RequestParam(required = false) final String name) {
    String message = name != null && ! name.isEmpty() ? String.format("Hello there, %s!", name) : "Hello there!";
    return ResponseEntity.ok(message);
  }
}
