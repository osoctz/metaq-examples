package cn.metaq.neo4j.model.entity;

import cn.metaq.common.core.IEntity;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * 主题实体
 */
@Node
public class Subject implements IEntity<String> {

  @Id
  private String id;

  private String name;

  public Subject() {
  }

  public Subject(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
