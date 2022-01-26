package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>授权.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_authority")
@Setter
@Getter
public class Authority implements IEntity<Long>{

	private static final long serialVersionUID =  8299754789217620832L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 资源 */
	@Column(name = "resource_id" )
	private Long resourceId;

	/** 授权 */
	@Column(name = "authority" )
	private String authority;

}
