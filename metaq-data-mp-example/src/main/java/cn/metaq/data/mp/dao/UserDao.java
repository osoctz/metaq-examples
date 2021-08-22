package cn.metaq.data.mp.dao;

import cn.metaq.data.mp.BaseDao;
import cn.metaq.data.mp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao<User,Long> {
}
