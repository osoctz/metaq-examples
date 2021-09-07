package cn.metaq.auth.security.biz;

import cn.metaq.auth.security.entity.User;
import cn.metaq.common.core.qo.QueryWrapper;
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
public interface UserBiz extends Biz<User, Long>, QueryBiz<QueryWrapper, Specification> {
}
