package cn.metaq.example.jpa.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Aug 17 16:20:48 CST 2021.</p>
 * <p>null.</p>
 *
 * @author tom
 */
@Entity
@Table(name = "user_role")
@Setter
@Getter
public class UserRole implements IEntity<Long>{

	private static final long serialVersionUID =  5026068196822419404L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;

	/**
	 * 用户ID
	 */
	@Column(name = "userId" )
	private Long userId;

	/**
	 * 角色ID
	 */
	@Column(name = "roleId" )
	private Long roleId;

}
