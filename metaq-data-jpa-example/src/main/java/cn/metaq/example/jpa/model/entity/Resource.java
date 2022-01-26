package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>资源.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_resource")
@Setter
@Getter
public class Resource implements IEntity<Long>{

	private static final long serialVersionUID =  940763416443753847L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 资源名称 */
	@Column(name = "name" )
	private String name;

	/** 资源代码 */
	@Column(name = "code" )
	private String code;

	/**  1 目录 2 页面    3 元素 */
	@Column(name = "type" )
	private Integer type;

	/** 优先级 */
	@Column(name = "priority" )
	private Integer priority;

}
