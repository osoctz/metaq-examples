package cn.metaq.example.jpa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import org.springframework.data.jpa.domain.Specification;
import cn.metaq.example.jpa.model.entity.UserRole;
import cn.metaq.example.jpa.model.qo.UserRoleQo;

/**
 * <p>Date: Tue Nov 30 11:32:23 CST 2021.</p>
 *
 * @author zantang
 */
public interface UserRoleBiz extends Biz<UserRole,Long>, QueryBiz<UserRoleQo, Specification> {

}
