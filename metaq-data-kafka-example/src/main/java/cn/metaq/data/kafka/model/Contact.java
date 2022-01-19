package cn.metaq.data.kafka.model;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {

  private Integer source;
  private String ori_url;
  private String name;

  private List<Organization> organizations;

  public Integer getSource() {
    return source;
  }

  public void setSource(Integer source) {
    this.source = source;
  }

  public String getOri_url() {
    return ori_url;
  }

  public void setOri_url(String ori_url) {
    this.ori_url = ori_url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Organization> getOrganizations() {
    return organizations;
  }

  public void setOrganizations(List<Organization> organizations) {
    this.organizations = organizations;
  }
}
