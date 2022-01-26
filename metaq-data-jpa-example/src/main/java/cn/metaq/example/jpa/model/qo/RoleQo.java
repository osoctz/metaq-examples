package cn.metaq.example.jpa.model.qo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:29 CST 2021.</p>
 * <p>角色.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class RoleQo implements Serializable{

	private static final long serialVersionUID =  8665632328597641078L;

	private Long id;

	/** 角色名称 */
	private String name;

	/** 角色代码 */
	private String code;

}
