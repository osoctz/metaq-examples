package cn.metaq.auth.security.dao;

import cn.metaq.auth.security.entity.Role;
import cn.metaq.data.jpa.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * RoleDao
 *
 * @author tz
 * @date 2020/11/27 下午1:30
 * @since 1.0
 */
@Repository
public interface RoleDao extends BaseDao<Role, Long> {
}
