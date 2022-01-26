package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>组.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class GroupDTO implements Serializable{

	private static final long serialVersionUID =  8033920079564323992L;

	private Long id;

	/** 名称 */
	private String name;

	/** 0-组织机构 1-部门 */
	private Integer type;

	/** 层级 */
	private Integer level;

	/** 优先级 */
	private Integer priority;

	/** 父级 */
	private Long pid;

}
