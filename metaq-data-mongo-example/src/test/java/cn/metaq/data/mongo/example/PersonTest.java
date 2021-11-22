package cn.metaq.data.mongo.example;

import cn.metaq.data.mongo.example.biz.PersonBiz;
import cn.metaq.data.mongo.example.entity.Person;
import org.bson.codecs.ObjectIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonTest {

    @Autowired
    private PersonBiz personBiz;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testCreate(){

        Person p=new Person();
        p.setName("tom");
        p.setAge(18);
        p.setId(34);

        //personBiz.save(p);
        mongoTemplate.insert(p);
    }

    @Test
    public void testCommonObjectCreate(){

        List<Map<String,Object>> data=new ArrayList<Map<String, Object>>();

        Map<String,Object> row=new HashMap<>();
        row.put("name","tom");
        row.put("age",111);

        Map<String,Object> row2=new HashMap<>();
        row2.put("name","zantang");
        row2.put("age",33);

        data.add(row);
        data.add(row2);

        //mongoTemplate.insert(data,"common_object");
        mongoTemplate.insert(data,HashMap.class);
    }

    public void testQuery(){


    }
}
