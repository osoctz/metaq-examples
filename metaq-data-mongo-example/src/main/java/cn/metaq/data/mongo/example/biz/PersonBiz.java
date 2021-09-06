package cn.metaq.data.mongo.example.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.mongo.MongoQueryBiz;
import cn.metaq.data.mongo.example.entity.Person;

public interface PersonBiz extends Biz<Person,Integer>, MongoQueryBiz<Person> {
}
