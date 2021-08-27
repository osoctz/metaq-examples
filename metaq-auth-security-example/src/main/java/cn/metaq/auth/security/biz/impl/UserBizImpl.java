package cn.metaq.auth.security.biz.impl;

import cn.metaq.auth.security.biz.UserBiz;
import cn.metaq.auth.security.dao.UserDao;
import cn.metaq.auth.security.entity.User;
import cn.metaq.data.jpa.BaseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * UserBizImpl
 *
 * @author tz
 * @date 2020/11/20 下午12:07
 * @since 1.0
 */
@Service
public class UserBizImpl extends BaseBiz<User, User, Long, UserDao> implements UserBiz {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User entity) {

        entity.setLastPasswordResetDate(new Date());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        super.save(entity);
    }

    @Override
    public Specification map(User dto) {
        return null;
    }
}
