package cn.metaq.data.mp.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.data.mp.entity.User;
import cn.metaq.data.mp.qo.UserQo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public interface UserBiz extends Biz<User, Long>, QueryBiz<UserQo, QueryWrapper> {

}
