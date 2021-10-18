package io.unravelling.demos.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"io.unravelling.demos.springboot.hello"})
public class HelloApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloApplication.class, args);
  }

}
