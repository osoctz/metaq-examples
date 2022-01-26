package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>角色授权.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_role_authority")
@Setter
@Getter
public class RoleAuthority implements IEntity<Long>{

	private static final long serialVersionUID =  7619629363967760966L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 角色 */
	@Column(name = "role_id" )
	private Long roleId;

	/** 授权 */
	@Column(name = "authority_id" )
	private Long authorityId;

}
