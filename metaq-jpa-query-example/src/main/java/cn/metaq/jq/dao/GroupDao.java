package cn.metaq.jq.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.jq.entity.Group;
import cn.metaq.jq.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <p>Date: Sun Oct 31 11:35:44 CST 2021.</p>
 * <p>用户.</p>
 *
 * @author tom
 */
@Repository
public interface GroupDao extends BaseDao<Group, Long>{

}
