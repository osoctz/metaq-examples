package cn.metaq.es.example.config;

import cn.metaq.data.es.EsHighRestClient;
import cn.metaq.data.es.EsTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class ElasticsearchConfiguration {

  @Value("${es.servers}")
  private String servers;

  @Bean(destroyMethod = "close")
  public EsHighRestClient esHighRestClient() {

    return new EsHighRestClient(servers);
  }

  @Bean
  public EsTemplate esTemplate() {

    EsTemplate esTemplate = new EsTemplate();
    esTemplate.setClient(esHighRestClient());
    return esTemplate;
  }
}