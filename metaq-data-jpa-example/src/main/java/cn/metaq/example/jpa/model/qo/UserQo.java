package cn.metaq.example.jpa.model.qo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:29 CST 2021.</p>
 * <p>用户.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class UserQo implements Serializable{

	private static final long serialVersionUID =  2735263673335106821L;

	private Long id;

	/** 用户名称 */
	private String name;

	/** 用户名 */
	private String username;

	/** 密码 */
	private String password;

	/** 邮箱 */
	private String email;

	/** 0-启用 1-禁用 */
	private Boolean enabled;

	/** 最近密码重置时间 */
	private java.util.Date lastPasswordResetDate;

	/** 创建者 */
	private String createdBy;

	/** 创建时间 */
	private java.util.Date createdTs;

	/** 更新者 */
	private String updatedBy;

	/** 更新时间 */
	private java.util.Date updatedTs;

}
