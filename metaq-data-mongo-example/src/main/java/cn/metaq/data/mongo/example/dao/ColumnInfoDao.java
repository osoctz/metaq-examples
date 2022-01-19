package cn.metaq.data.mongo.example.dao;

import cn.metaq.data.mongo.example.entity.ColumnInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColumnInfoDao extends MongoRepository<ColumnInfo,String> {

}
