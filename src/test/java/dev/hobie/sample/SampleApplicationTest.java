package dev.hobie.sample;

import dev.hobie.sample.controller.HomeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleApplicationTest {

  @Autowired HomeController controller;

  @Test
  void contextLoads() {
    Assertions.assertThat(controller).isNotNull();
  }
}
