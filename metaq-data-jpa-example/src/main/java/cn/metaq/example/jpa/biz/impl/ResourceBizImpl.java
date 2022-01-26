package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.Resource;
import cn.metaq.example.jpa.model.qo.ResourceQo;
import cn.metaq.example.jpa.biz.ResourceBiz;
import cn.metaq.example.jpa.dao.ResourceDao;
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
public class ResourceBizImpl extends BaseBiz<Resource,ResourceQo,Long,ResourceDao> implements ResourceBiz {

	@Override
	public Specification map(ResourceQo resourceQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != resourceQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), resourceQo.getId()));
			}
			 if (null != resourceQo.getName()) {
				 predicates.add(cb.equal(root.get("name"), resourceQo.getName()));
			}
			 if (null != resourceQo.getCode()) {
				 predicates.add(cb.equal(root.get("code"), resourceQo.getCode()));
			}
			 if (null != resourceQo.getType()) {
				 predicates.add(cb.equal(root.get("type"), resourceQo.getType()));
			}
			 if (null != resourceQo.getPriority()) {
				 predicates.add(cb.equal(root.get("priority"), resourceQo.getPriority()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
