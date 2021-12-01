package cn.metaq.neo4j.model.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * 地名实体
 */
@Node
public class Place {

  @Id
  private String id;

  private String name;

  public Place() {
  }

  public Place(String name) {
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
