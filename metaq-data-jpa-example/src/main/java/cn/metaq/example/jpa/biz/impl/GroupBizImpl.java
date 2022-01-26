package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.Group;
import cn.metaq.example.jpa.model.qo.GroupQo;
import cn.metaq.example.jpa.biz.GroupBiz;
import cn.metaq.example.jpa.dao.GroupDao;
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
public class GroupBizImpl extends BaseBiz<Group,GroupQo,Long,GroupDao> implements GroupBiz {

	@Override
	public Specification map(GroupQo groupQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != groupQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), groupQo.getId()));
			}
			 if (null != groupQo.getName()) {
				 predicates.add(cb.equal(root.get("name"), groupQo.getName()));
			}
			 if (null != groupQo.getType()) {
				 predicates.add(cb.equal(root.get("type"), groupQo.getType()));
			}
			 if (null != groupQo.getLevel()) {
				 predicates.add(cb.equal(root.get("level"), groupQo.getLevel()));
			}
			 if (null != groupQo.getPriority()) {
				 predicates.add(cb.equal(root.get("priority"), groupQo.getPriority()));
			}
			 if (null != groupQo.getPid()) {
				 predicates.add(cb.equal(root.get("pid"), groupQo.getPid()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
