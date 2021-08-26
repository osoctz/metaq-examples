package cn.metaq.data.jdbc.dao;

import cn.metaq.data.jdbc.BaseDao;
import cn.metaq.data.jdbc.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User,Long> {
}
