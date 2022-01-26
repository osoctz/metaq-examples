package cn.metaq.jq.entity;

import cn.metaq.common.core.IEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * <p>Date: Sun Oct 31 11:31:03 CST 2021.</p>
 * <p>组.</p>
 *
 * @author tom
 */
@Entity
@Table(name = "t_id_group")
@Setter
@Getter
public class Group implements IEntity<Long>{

	private static final long serialVersionUID =  3802043345788440373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;

	/**
	 * 名称
	 */
	@Column(name = "name" )
	private String name;

	/**
	 * 0-组织机构 1-部门
	 */
	@Column(name = "type" )
	private Long type;

	/**
	 * 层级
	 */
	@Column(name = "level" )
	private Long level;

	/**
	 * 优先级
	 */
	@Column(name = "priority" )
	private Long priority;

//	/**
//	 * 父级
//	 */
//	@Column(name = "pid" )
//	private Long pid;

	@ManyToOne
	@JoinColumn(name="pid")
	private Group parent;

	@OneToMany(mappedBy = "parent",fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@OrderBy(value="priority ASC")
	private List<Group> children;
}
