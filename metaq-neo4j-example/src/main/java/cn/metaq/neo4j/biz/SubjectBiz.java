package cn.metaq.neo4j.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.neo4j.model.entity.Subject;
import org.neo4j.cypherdsl.core.Condition;

public interface SubjectBiz extends Biz<Subject,String>, QueryBiz<Subject, Condition> {

}
