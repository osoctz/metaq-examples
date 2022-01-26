package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.Role;
import cn.metaq.example.jpa.model.qo.RoleQo;
import cn.metaq.example.jpa.biz.RoleBiz;
import cn.metaq.example.jpa.dao.RoleDao;
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
public class RoleBizImpl extends BaseBiz<Role,RoleQo,Long,RoleDao> implements RoleBiz {

	@Override
	public Specification map(RoleQo roleQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != roleQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), roleQo.getId()));
			}
			 if (null != roleQo.getName()) {
				 predicates.add(cb.equal(root.get("name"), roleQo.getName()));
			}
			 if (null != roleQo.getCode()) {
				 predicates.add(cb.equal(root.get("code"), roleQo.getCode()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
