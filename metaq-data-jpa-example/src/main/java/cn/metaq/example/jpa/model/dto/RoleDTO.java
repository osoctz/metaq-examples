package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>角色.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class RoleDTO implements Serializable{

	private static final long serialVersionUID =  2986046495808721789L;

	private Long id;

	/** 角色名称 */
	private String name;

	/** 角色代码 */
	private String code;

}
