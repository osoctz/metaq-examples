package cn.metaq.el;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

  public void test(){

    List list=new ArrayList<>();
  }

  public static class Person{
    private String name;
    private int age;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }
}
