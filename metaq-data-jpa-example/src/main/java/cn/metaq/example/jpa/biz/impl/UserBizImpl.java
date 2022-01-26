package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.example.jpa.model.entity.User;
import cn.metaq.example.jpa.model.qo.UserQo;
import cn.metaq.example.jpa.biz.UserBiz;
import cn.metaq.example.jpa.dao.UserDao;
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
public class UserBizImpl extends BaseBiz<User,UserQo,Long,UserDao> implements UserBiz {

	@Override
	public Specification map(UserQo userQo) {
		return (root, cq, cb) -> {
			 List<Predicate> predicates = new ArrayList<>();
			 if (null != userQo.getId()) {
				 predicates.add(cb.equal(root.get("id"), userQo.getId()));
			}
			 if (null != userQo.getName()) {
				 predicates.add(cb.equal(root.get("name"), userQo.getName()));
			}
			 if (null != userQo.getUsername()) {
				 predicates.add(cb.equal(root.get("username"), userQo.getUsername()));
			}
			 if (null != userQo.getPassword()) {
				 predicates.add(cb.equal(root.get("password"), userQo.getPassword()));
			}
			 if (null != userQo.getEmail()) {
				 predicates.add(cb.equal(root.get("email"), userQo.getEmail()));
			}
			 if (null != userQo.getEnabled()) {
				 predicates.add(cb.equal(root.get("enabled"), userQo.getEnabled()));
			}
			 if (null != userQo.getLastPasswordResetDate()) {
				 predicates.add(cb.equal(root.get("lastPasswordResetDate"), userQo.getLastPasswordResetDate()));
			}
			 if (null != userQo.getCreatedBy()) {
				 predicates.add(cb.equal(root.get("createdBy"), userQo.getCreatedBy()));
			}
			 if (null != userQo.getCreatedTs()) {
				 predicates.add(cb.equal(root.get("createdTs"), userQo.getCreatedTs()));
			}
			 if (null != userQo.getUpdatedBy()) {
				 predicates.add(cb.equal(root.get("updatedBy"), userQo.getUpdatedBy()));
			}
			 if (null != userQo.getUpdatedTs()) {
				 predicates.add(cb.equal(root.get("updatedTs"), userQo.getUpdatedTs()));
			}
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
