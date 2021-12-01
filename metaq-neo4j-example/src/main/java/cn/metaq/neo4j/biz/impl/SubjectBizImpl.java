package cn.metaq.neo4j.biz.impl;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.data.neo4j.BaseBiz;
import cn.metaq.neo4j.biz.SubjectBiz;
import cn.metaq.neo4j.dao.SubjectDao;
import cn.metaq.neo4j.model.entity.Subject;
import java.util.List;
import org.neo4j.cypherdsl.core.Condition;
import org.springframework.stereotype.Service;

@Service
public class SubjectBizImpl extends BaseBiz<Subject,Subject,String, SubjectDao> implements SubjectBiz {

  @Override
  public Condition map(Subject subject) {
    return null;
  }

  @Override
  public <R> R getOneById(Class<R> aClass, String id) {
    return null;
  }

  @Override
  public <R> List<R> list(Class<R> aClass) {
    return null;
  }

  @Override
  public void save(Subject subject) {

  }

  @Override
  public void update(Subject subject) {

  }

  @Override
  public <R> void deleteById(Class<R> aClass, String s) {

  }

  @Override
  public <R> R getOne(Class<R> aClass, Subject subject) {
    return null;
  }

  @Override
  public <R> List<R> list(Class<R> aClass, Subject subject) {
    return null;
  }

  @Override
  public <R> List<R> list(Class<R> aClass, Subject subject, String[] strings) {
    return null;
  }

  @Override
  public <R> List<R> list(Class<R> aClass, Subject subject, String[] strings, String s) {
    return null;
  }

  @Override
  public <R> Pagination<R> list(Class<R> aClass, Subject subject, int i, int i1) {
    return null;
  }

  @Override
  public <R> Pagination<R> list(Class<R> aClass, Subject subject, int i, int i1, String[] strings) {
    return null;
  }

  @Override
  public <R> Pagination<R> list(Class<R> aClass, Subject subject, int i, int i1, String[] strings, String s) {
    return null;
  }

  @Override
  public Long count(Subject subject) {
    return null;
  }
}
