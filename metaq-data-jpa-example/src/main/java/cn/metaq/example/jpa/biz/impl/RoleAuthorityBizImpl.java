package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.RoleAuthority;
import cn.metaq.example.jpa.model.qo.RoleAuthorityQo;
import cn.metaq.example.jpa.biz.RoleAuthorityBiz;
import cn.metaq.example.jpa.dao.RoleAuthorityDao;
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
public class RoleAuthorityBizImpl extends BaseBiz<RoleAuthority,RoleAuthorityQo,Long,RoleAuthorityDao> implements RoleAuthorityBiz {

	@Override
	public Specification map(RoleAuthorityQo roleAuthorityQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != roleAuthorityQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), roleAuthorityQo.getId()));
			}
			 if (null != roleAuthorityQo.getRoleId()) {
				 predicates.add(cb.equal(root.get("roleId"), roleAuthorityQo.getRoleId()));
			}
			 if (null != roleAuthorityQo.getAuthorityId()) {
				 predicates.add(cb.equal(root.get("authorityId"), roleAuthorityQo.getAuthorityId()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
