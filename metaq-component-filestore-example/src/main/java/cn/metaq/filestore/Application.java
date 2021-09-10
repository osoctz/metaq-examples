package cn.metaq.filestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication(scanBasePackages = {"cn.metaq.filestore", "cn.metaq.oss"})
@EnableOpenApi
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
