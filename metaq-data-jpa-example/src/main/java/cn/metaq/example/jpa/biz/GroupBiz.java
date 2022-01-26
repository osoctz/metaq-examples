package cn.metaq.example.jpa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import org.springframework.data.jpa.domain.Specification;
import cn.metaq.example.jpa.model.entity.Group;
import cn.metaq.example.jpa.model.qo.GroupQo;

/**
 * <p>Date: Tue Nov 30 11:32:23 CST 2021.</p>
 *
 * @author zantang
 */
public interface GroupBiz extends Biz<Group,Long>, QueryBiz<GroupQo, Specification> {

}
