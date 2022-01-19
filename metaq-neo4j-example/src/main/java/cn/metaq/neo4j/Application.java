package cn.metaq.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class Application {

  @Scheduled(cron = "0/5 * * * * ?    ")
  public void execute(){
    System.out.println("aaaaaaa");
  }
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
