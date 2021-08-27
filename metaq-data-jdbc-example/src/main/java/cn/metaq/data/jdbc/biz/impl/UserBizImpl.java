package cn.metaq.data.jdbc.biz.impl;

import cn.metaq.data.jdbc.BaseBiz;
import cn.metaq.data.jdbc.biz.UserBiz;
import cn.metaq.data.jdbc.dao.UserDao;
import cn.metaq.data.jdbc.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl extends BaseBiz<User,User,Long, UserDao> implements UserBiz {

}
