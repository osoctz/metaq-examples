package cn.metaq.data.mongo.example.biz.impl;

import cn.metaq.data.mongo.BaseBiz;
import cn.metaq.data.mongo.example.biz.PersonBiz;
import cn.metaq.data.mongo.example.entity.Person;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class PersonBizImpl extends BaseBiz<Person,Integer> implements PersonBiz{
    @Override
    public Query map(Person person) {

//        Query.query()
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is("Eric"));
//        query.addCriteria(Criteria.where("age").is("1"));
        return null;
    }
}
