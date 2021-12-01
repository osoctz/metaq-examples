package cn.metaq.data.mp.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {

  @Bean
  public IdentifierGenerator idGenerator() {
    return new CustomIdGenerator();
  }
}
