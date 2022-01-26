package cn.metaq.jq.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.jq.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>Date: Sun Oct 31 11:35:44 CST 2021.</p>
 * <p>用户.</p>
 *
 * @author tom
 */
@Repository
public interface UserDao extends BaseDao<User, Long>{
}
