package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.UserRole;
import cn.metaq.example.jpa.model.qo.UserRoleQo;
import cn.metaq.example.jpa.biz.UserRoleBiz;
import cn.metaq.example.jpa.dao.UserRoleDao;
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
public class UserRoleBizImpl extends BaseBiz<UserRole,UserRoleQo,Long,UserRoleDao> implements UserRoleBiz {

	@Override
	public Specification map(UserRoleQo userRoleQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != userRoleQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), userRoleQo.getId()));
			}
			 if (null != userRoleQo.getUserId()) {
				 predicates.add(cb.equal(root.get("userId"), userRoleQo.getUserId()));
			}
			 if (null != userRoleQo.getRoleId()) {
				 predicates.add(cb.equal(root.get("roleId"), userRoleQo.getRoleId()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
