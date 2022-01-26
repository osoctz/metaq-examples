package cn.metaq.jq.entity;

import cn.metaq.common.core.IEntity;
import com.vladmihalcea.hibernate.type.json.JsonType;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "data_quality_record")
@Setter
@Getter
@TypeDef(
    name = "json",
    typeClass = JsonType.class
)
public class DataQualityRecord implements IEntity<String> {

  @Id
  @GeneratedValue(generator = "snowflakeId")
  @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
  @Column(name = "id" )
  private String id;

  @Column(name = "check_time" )
  private Long checkTime;
  @Column(name = "table_name" )
  private String tableName;

  @Type(type = "json")
  @Column(name = "tag_count_map",columnDefinition = "jsonb")
  private Map tagCountMap;
}
