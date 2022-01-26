package cn.metaq.example.jpa.model.qo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:29 CST 2021.</p>
 * <p>角色授权.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class RoleAuthorityQo implements Serializable{

	private static final long serialVersionUID =  5212543606914604839L;

	private Long id;

	/** 角色 */
	private Long roleId;

	/** 授权 */
	private Long authorityId;

}
