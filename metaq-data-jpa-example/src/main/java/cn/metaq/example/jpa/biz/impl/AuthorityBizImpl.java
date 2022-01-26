package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.Authority;
import cn.metaq.example.jpa.model.qo.AuthorityQo;
import cn.metaq.example.jpa.biz.AuthorityBiz;
import cn.metaq.example.jpa.dao.AuthorityDao;
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
public class AuthorityBizImpl extends BaseBiz<Authority,AuthorityQo,Long,AuthorityDao> implements AuthorityBiz {

	@Override
	public Specification map(AuthorityQo authorityQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != authorityQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), authorityQo.getId()));
			}
			 if (null != authorityQo.getResourceId()) {
				 predicates.add(cb.equal(root.get("resourceId"), authorityQo.getResourceId()));
			}
			 if (null != authorityQo.getAuthority()) {
				 predicates.add(cb.equal(root.get("authority"), authorityQo.getAuthority()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
