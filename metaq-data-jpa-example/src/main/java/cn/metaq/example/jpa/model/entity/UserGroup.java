package cn.metaq.example.jpa.model.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Date: Tue Nov 30 11:29:52 CST 2021.</p>
 * <p>用户与组.</p>
 *
 * @author zantang
 */
@Entity
@Table(name = "t_id_user_ext")
@Setter
@Getter
public class UserGroup implements IEntity<Long>{

	private static final long serialVersionUID =  8869211844986226367L;

	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.IdGenerator")
	@Column(name = "id" )
	private Long id;

	/** 用户 */
	@Column(name = "user_id" )
	private Long userId;

	/** 组 */
	@Column(name = "group_id" )
	private Long groupId;

}
