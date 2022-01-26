package cn.metaq.example.jpa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import org.springframework.data.jpa.domain.Specification;
import cn.metaq.example.jpa.model.entity.UserGroup;
import cn.metaq.example.jpa.model.qo.UserGroupQo;

/**
 * <p>Date: Tue Nov 30 11:32:23 CST 2021.</p>
 *
 * @author zantang
 */
public interface UserGroupBiz extends Biz<UserGroup,Long>, QueryBiz<UserGroupQo, Specification> {

}
