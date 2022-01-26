package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>资源.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class ResourceDTO implements Serializable{

	private static final long serialVersionUID =  4391179916836236689L;

	private Long id;

	/** 资源名称 */
	private String name;

	/** 资源代码 */
	private String code;

	/**  1 目录 2 页面    3 元素 */
	private Integer type;

	/** 优先级 */
	private Integer priority;

}
