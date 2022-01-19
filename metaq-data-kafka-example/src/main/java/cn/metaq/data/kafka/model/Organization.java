package cn.metaq.data.kafka.model;

import java.io.Serializable;

public class Organization implements Serializable {

  private String name;
  private String ori_name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOri_name() {
    return ori_name;
  }

  public void setOri_name(String ori_name) {
    this.ori_name = ori_name;
  }
}
