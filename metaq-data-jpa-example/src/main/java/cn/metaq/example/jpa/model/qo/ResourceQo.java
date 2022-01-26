package cn.metaq.example.jpa.model.qo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:29 CST 2021.</p>
 * <p>资源.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class ResourceQo implements Serializable{

	private static final long serialVersionUID =  5632900382130530857L;

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
