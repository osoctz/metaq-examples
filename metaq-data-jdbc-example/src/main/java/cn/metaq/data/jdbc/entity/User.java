package cn.metaq.data.jdbc.entity;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * <p>Date: Thu Aug 26 20:07:24 CST 2021.</p>
 * <p>null.</p>
 *
 * @author tom
 */
@Table(value = "user")
@Setter
@Getter
public class User implements IEntity<Long>{

	private static final long serialVersionUID =  3166840902336718651L;

	/**
	 * ID
	 */
	@Id
	@Column(value = "id" )
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 登录名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 最近密码重置时间
	 */
	private java.util.Date lastPasswordResetDate;

	/**
	 * 是否启用 0-启用 1-禁用
	 */
	private Long enabled;

}
