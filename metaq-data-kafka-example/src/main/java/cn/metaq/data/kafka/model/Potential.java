package cn.metaq.data.kafka.model;

import java.io.Serializable;
import java.util.List;

public class Potential implements Serializable {

  private Integer source;
  private String ori_url;
  private String ori_name;
  private List<Contact> contacts;

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

  public String getOri_name() {
    return ori_name;
  }

  public void setOri_name(String ori_name) {
    this.ori_name = ori_name;
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }
}
