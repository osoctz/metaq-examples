package cn.metaq.example.jpa.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Aug 17 16:21:06 CST 2021.</p>
 * <p>null.</p>
 *
 * @author tom
 */
@Entity
@Table(name = "role")
@Setter
@Getter
public class Role implements IEntity<Long>{

	private static final long serialVersionUID =  4752717132922289493L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;

	/**
	 * 角色名
	 */
	@Column(name = "name" )
	private String name;

	/**
	 * 角色编码
	 */
	@Column(name = "code" )
	private String code;

}
