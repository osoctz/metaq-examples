package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>角色授权.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class RoleAuthorityDTO implements Serializable{

	private static final long serialVersionUID =  8291892616356323322L;

	private Long id;

	/** 角色 */
	private Long roleId;

	/** 授权 */
	private Long authorityId;

}
