package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>用户角色.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_user_role")
@Setter
@Getter
public class UserRole implements IEntity<Long>{

	private static final long serialVersionUID =  7598136155523590272L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 用户 */
	@Column(name = "user_id" )
	private Long userId;

	/** 角色 */
	@Column(name = "role_id" )
	private Long roleId;

}
