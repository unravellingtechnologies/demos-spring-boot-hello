package io.unravelling.demos.springboot.hello;

import static org.assertj.core.api.Assertions.assertThat;

import io.unravelling.demos.springboot.hello.controllers.HelloController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

  @Autowired
  private HelloController helloController;

  @Test
  void contextLoads() {
    assertThat(helloController).isNotNull();
  }

}
