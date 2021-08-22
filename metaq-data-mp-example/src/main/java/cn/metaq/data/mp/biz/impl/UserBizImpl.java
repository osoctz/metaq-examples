package cn.metaq.data.mp.biz.impl;

import cn.metaq.data.mp.BaseBiz;
import cn.metaq.data.mp.biz.UserBiz;
import cn.metaq.data.mp.dao.UserDao;
import cn.metaq.data.mp.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl extends BaseBiz<User,User,Long, UserDao> implements UserBiz {
}
