package cn.metaq.auth.security.dao;

import cn.metaq.auth.security.entity.User;
import cn.metaq.data.jpa.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * UserDao
 *
 * @author tz
 * @date 2020/11/20 下午12:05
 * @since 1.0
 */
@Repository
public interface UserDao extends BaseDao<User, Long> {
}
