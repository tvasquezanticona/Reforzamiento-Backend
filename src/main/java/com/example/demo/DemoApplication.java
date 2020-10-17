package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>Class:</b> DemoApplication.</br>
 * @author RLR
 * @version 1.0.0
 */

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Student API", version = "2.0", description = "Student Description"))
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class);
  }

}
