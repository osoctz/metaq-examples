package cn.metaq.jq.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Sun Oct 31 11:31:03 CST 2021.</p>
 * <p>用户与组.</p>
 *
 * @author tom
 */
@Entity
@Table(name = "t_id_user_group")
@Setter
@Getter
public class UserGroup implements IEntity<Long>{

	private static final long serialVersionUID =  3231822979774899401L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;

//	/**
//	 * 用户
//	 */
//	@Column(name = "user_id",unique = true)
//	private Long userId;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * 组
	 */
	@Column(name = "group_id" )
	private Long groupId;

	@Column(name = "group_parent_ids")
	private String groupParentIds;
}
