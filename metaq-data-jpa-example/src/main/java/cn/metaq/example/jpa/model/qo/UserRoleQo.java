package cn.metaq.example.jpa.model.qo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:29 CST 2021.</p>
 * <p>用户角色.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class UserRoleQo implements Serializable{

	private static final long serialVersionUID =  1422393260098022725L;

	private Long id;

	/** 用户 */
	private Long userId;

	/** 角色 */
	private Long roleId;

}
