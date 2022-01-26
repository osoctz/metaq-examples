package cn.metaq.jq.entity;

import cn.metaq.common.core.IEntity;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;

/**
 * <p>Date: Sun Oct 31 11:31:03 CST 2021.</p>
 * <p>用户.</p>
 *
 * @author tom
 */
@Entity
@Table(name = "t_id_user")
@Setter
@Getter
public class User implements IEntity<Long>{

	private static final long serialVersionUID =  2601435159744203154L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;

	/**
	 * 用户名称
	 */
	@Column(name = "name" )
	private String name;

	/**
	 * 用户名
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
	 * 0-启用 1-禁用
	 */
	@Column(name = "enabled" )
	private Integer enabled;

	/**
	 * 最近密码重置时间
	 */
	@Column(name = "last_password_reset_date" )
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastPasswordResetDate;

	/**
	 * 创建者
	 */
	@Column(name = "created_by" )
	private String createdBy;

	/**
	 * 创建时间
	 */
	@Column(name = "created_ts" )
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createdTs;

	/**
	 * 更新者
	 */
	@Column(name = "updated_by" )
	private String updatedBy;

	/**
	 * 更新时间
	 */
	@Column(name = "updated_ts" )
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date updatedTs;

//	@OneToOne
//	@JoinTable(name = "t_id_user_group",joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name = "group_id")})
//	private Group group;

//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id")
//	private List<UserGroup> userGroup;

	@OneToOne(mappedBy="user")
	private UserGroup userGroup;
}
