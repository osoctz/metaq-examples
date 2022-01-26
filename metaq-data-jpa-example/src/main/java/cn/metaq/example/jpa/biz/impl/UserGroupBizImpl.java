package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.UserGroup;
import cn.metaq.example.jpa.model.qo.UserGroupQo;
import cn.metaq.example.jpa.biz.UserGroupBiz;
import cn.metaq.example.jpa.dao.UserGroupDao;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Date: Tue Nov 30 11:32:35 CST 2021.</p>
 *
 * @author zantang
 */
@Service
public class UserGroupBizImpl extends BaseBiz<UserGroup,UserGroupQo,Long,UserGroupDao> implements UserGroupBiz {

	@Override
	public Specification map(UserGroupQo userGroupQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != userGroupQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), userGroupQo.getId()));
			}
			 if (null != userGroupQo.getUserId()) {
				 predicates.add(cb.equal(root.get("userId"), userGroupQo.getUserId()));
			}
			 if (null != userGroupQo.getGroupId()) {
				 predicates.add(cb.equal(root.get("groupId"), userGroupQo.getGroupId()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
