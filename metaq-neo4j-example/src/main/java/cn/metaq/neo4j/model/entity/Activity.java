package cn.metaq.neo4j.model.entity;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * 活动实体
 */
@Node
public class Activity {

  @Id
  private String id;
  private String name;

  public Activity() {
  }

  public Activity(String name) {
    this.name = name;
  }

  @Relationship(type = "考察地")
  private Set<Place> places;

  @Relationship(type = "考察主题")
  private Set<Subject> subjects;

  @Relationship(type = "考察人")
  private Set<Inspector> inspectors;

  @Relationship(type = "主考察人")
  private Inspector inspector;

  public void addPlace(Place place) {

    if (places == null) {
      places = new HashSet();
    }
    places.add(place);
  }

  public void addSubject(Subject subject) {

    if (subjects == null) {
      subjects = new HashSet<>();
    }
    subjects.add(subject);
  }

  public void addInspector(Inspector inspector) {

    if (inspectors == null) {
      inspectors = new HashSet<>();
    }
    inspectors.add(inspector);
  }

  public void setPlaces(Set<Place> places) {
    this.places = places;
  }

  public void setInspector(Inspector inspector) {
    this.inspector = inspector;
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

  public Set<Place> getPlaces() {
    return places;
  }

  public Set<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(Set<Subject> subjects) {
    this.subjects = subjects;
  }

  public void setInspectors(Set<Inspector> inspectors) {
    this.inspectors = inspectors;
  }

  public Set<Inspector> getInspectors() {
    return inspectors;
  }

  public Inspector getInspector() {
    return inspector;
  }
}
