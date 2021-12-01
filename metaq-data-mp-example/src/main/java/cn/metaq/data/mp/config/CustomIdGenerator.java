package cn.metaq.data.mp.config;

import cn.metaq.common.core.id.SnowflakeIdGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomIdGenerator implements IdentifierGenerator {

  private SnowflakeIdGenerator generator;

  public CustomIdGenerator() {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.parse("2012/12/12 23:59:59", dtf);
    Date d = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    this.generator = new SnowflakeIdGenerator(7, 3, true, 10, d, 3, 2, 7);
  }

  @Override
  public Number nextId(Object entity) {

    return generator.nextId();
  }
}
