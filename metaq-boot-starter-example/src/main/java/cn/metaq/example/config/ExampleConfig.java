package cn.metaq.example.config;

import cn.metaq.common.web.UserContext;
import cn.metaq.common.web.UserContextHolder;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.identity.model.entity.User;
import io.swagger.annotations.ApiOperation;
import javax.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableAspectJAutoProxy
public class ExampleConfig {

  @Bean
  public BaseTemplate template(EntityManager em) {
    return new BaseTemplate(em);
  }

  @Bean
  public Docket createApi(){
    return new Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .select()
        //.apis(RequestHandlerSelectors.basePackage("cn.metaq.identity.web"))
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo(){
    return new ApiInfoBuilder().title("测试api").build();
  }
}
