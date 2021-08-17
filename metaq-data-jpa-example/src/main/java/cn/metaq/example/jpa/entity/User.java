package cn.metaq.example.jpa.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Aug 17 02:25:35 CST 2021.</p>
 * <p>null.</p>
 *
 * @author tom
 */
@Entity
@Table(name = "user")
@Setter
@Getter
public class User implements IEntity<Long>{

	private static final long serialVersionUID =  6422962538379182860L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;

	/**
	 * 名称
	 */
	@Column(name = "name" )
	private String name;

	/**
	 * 登录名
	 */
	@Column(name = "username" )
	private String username;

	/**
	 * 密码
	 */
	@Column(name = "password" )
	private String password;

	/**
	 * 邮箱
	 */
	@Column(name = "email" )
	private String email;

	/**
	 * 最近密码重置时间
	 */
	@Column(name = "lastPasswordResetDate" )
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastPasswordResetDate;

	/**
	 * 是否启用 0-启用 1-禁用
	 */
	@Column(name = "enabled" )
	private Long enabled;

}
