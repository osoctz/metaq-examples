package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>角色.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_role")
@Setter
@Getter
public class Role implements IEntity<Long>{

	private static final long serialVersionUID =  3401573453563102228L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 角色名称 */
	@Column(name = "name" )
	private String name;

	/** 角色代码 */
	@Column(name = "code" )
	private String code;

}
