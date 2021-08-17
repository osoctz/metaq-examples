package cn.metaq.example.jpa.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>Date: Tue Aug 17 15:26:30 CST 2021.</p>
 * <p>null.</p>
 *
 * @author tom
 */
@Setter
@Getter
public class UserDTO implements IDto{

	private static final long serialVersionUID =  8837846177693238175L;

	public UserDTO() {
	}

	public UserDTO(Long id, String name, String username, String password, String email, Date lastPasswordResetDate, Long enabled) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.enabled = enabled;
	}

	/**
	 * ID
	 */
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
