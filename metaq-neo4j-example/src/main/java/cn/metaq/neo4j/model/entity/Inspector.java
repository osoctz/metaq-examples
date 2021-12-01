package cn.metaq.neo4j.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

/**
 * 考察人实体
 */
@Node
public class Inspector {

  @Id
  private String id;

  private String name;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @Relationship(type = "陪同",direction = Direction.INCOMING)
  private Set<Inspector> inspectors;

  public Inspector() {
  }

  public Inspector(String name) {
    this.name = name;
  }

  public void addInspector(Inspector inspector) {

    if (inspectors == null) {
      inspectors = new HashSet<>();
    }
    inspectors.add(inspector);
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

  public Set<Inspector> getInspectors() {
    return inspectors;
  }
}
