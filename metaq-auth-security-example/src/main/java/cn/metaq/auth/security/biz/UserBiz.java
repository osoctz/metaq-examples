package cn.metaq.auth.security.biz;

import cn.metaq.auth.security.entity.User;
import cn.metaq.data.Biz;
import cn.metaq.data.QueryWrapperBiz;

/**
 * UserBiz
 *
 * @author tz
 * @date 2020/11/20 下午12:06
 * @since 1.0
 */
public interface UserBiz extends Biz<User, User, Long>, QueryWrapperBiz<User> {
}
