package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>用户角色.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class UserRoleDTO implements Serializable{

	private static final long serialVersionUID =  7646396248117022700L;

	private Long id;

	/** 用户 */
	private Long userId;

	/** 角色 */
	private Long roleId;

}
