package cn.metaq.example.jpa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.example.jpa.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User, Long> {
}
