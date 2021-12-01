package cn.metaq.neo4j.dao;

import cn.metaq.data.neo4j.BaseDao;
import cn.metaq.neo4j.model.entity.Subject;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends BaseDao<Subject, String>, Neo4jRepository<Subject, String> {

}
