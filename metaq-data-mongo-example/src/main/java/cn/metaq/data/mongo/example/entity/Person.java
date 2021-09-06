package cn.metaq.data.mongo.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
//@Document(collection = "person_collection")
public class Person implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
}
