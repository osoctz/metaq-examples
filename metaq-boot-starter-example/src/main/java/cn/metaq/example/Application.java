package cn.metaq.example;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
@EnableBatchProcessing
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
