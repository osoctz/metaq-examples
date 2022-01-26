package cn.metaq.example.jpa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import org.springframework.data.jpa.domain.Specification;
import cn.metaq.example.jpa.model.entity.RoleAuthority;
import cn.metaq.example.jpa.model.qo.RoleAuthorityQo;

/**
 * <p>Date: Tue Nov 30 11:32:23 CST 2021.</p>
 *
 * @author zantang
 */
public interface RoleAuthorityBiz extends Biz<RoleAuthority,Long>, QueryBiz<RoleAuthorityQo, Specification> {

}
