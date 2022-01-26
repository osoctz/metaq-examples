package cn.metaq.example.jpa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.example.jpa.model.entity.Authority;
import cn.metaq.example.jpa.model.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * <p>Date: Tue Nov 30 11:31:48 CST 2021.</p>
 *
 * @author zantang
 */
@Repository
public interface UserDao extends BaseDao<User, Long>, QuerydslPredicateExecutor<User> {

}
