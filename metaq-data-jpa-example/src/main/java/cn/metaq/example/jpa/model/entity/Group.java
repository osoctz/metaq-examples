package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>组.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_group")
@Setter
@Getter
public class Group implements IEntity<Long>{

	private static final long serialVersionUID =  3868566950051043171L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 名称 */
	@Column(name = "name" )
	private String name;

	/** 0-组织机构 1-部门 */
	@Column(name = "type" )
	private Integer type;

	/** 层级 */
	@Column(name = "level" )
	private Integer level;

	/** 优先级 */
	@Column(name = "priority" )
	private Integer priority;

	/** 父级 */
	@Column(name = "pid" )
	private Long pid;

}
