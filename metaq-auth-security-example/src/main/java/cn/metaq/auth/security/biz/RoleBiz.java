package cn.metaq.auth.security.biz;

import cn.metaq.auth.security.dto.RoleDTO;
import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import org.springframework.data.jpa.domain.Specification;

/**
 * UserBiz
 *
 * @author tz
 * @date 2020/11/20 下午12:06
 * @since 1.0
 */
public interface RoleBiz extends Biz<RoleDTO, Long> , QueryBiz<RoleDTO, Specification> {
}
