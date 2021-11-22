package cn.metaq.data.mp.biz.impl;

import cn.metaq.data.mp.BaseBiz;
import cn.metaq.data.mp.biz.UserBiz;
import cn.metaq.data.mp.dao.UserDao;
import cn.metaq.data.mp.entity.User;
import cn.metaq.data.mp.qo.UserQo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl extends BaseBiz<User,UserQo,Long, UserDao> implements UserBiz {

  @Override
  public QueryWrapper<User> map(UserQo userQo) {

    QueryWrapper<User> qw=new QueryWrapper<>();

    if(userQo.getName()!=null){
      qw.eq("name",userQo.getName());
    }

    if(userQo.getUsername()!=null){
      qw.eq("username",userQo.getName());
    }

    return null;
  }
}
