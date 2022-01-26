package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>用户.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_user")
@Setter
@Getter
public class User implements IEntity<Long>{

	private static final long serialVersionUID =  5238729560142521222L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 用户名称 */
	@Column(name = "name" )
	private String name;

	/** 用户名 */
	@Column(name = "username" )
	private String username;

	/** 密码 */
	@Column(name = "password" )
	private String password;

	/** 邮箱 */
	@Column(name = "email" )
	private String email;

	/** 0-启用 1-禁用 */
	@Column(name = "enabled" )
	private Boolean enabled;

	/** 最近密码重置时间 */
	@Column(name = "last_password_reset_date" )
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastPasswordResetDate;

	/** 创建者 */
	@Column(name = "created_by" )
	private String createdBy;

	/** 创建时间 */
	@Column(name = "created_ts" )
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createdTs;

	/** 更新者 */
	@Column(name = "updated_by" )
	private String updatedBy;

	/** 更新时间 */
	@Column(name = "updated_ts" )
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date updatedTs;

}
