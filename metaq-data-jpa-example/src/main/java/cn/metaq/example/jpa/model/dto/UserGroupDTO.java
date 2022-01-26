package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>用户与组.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class UserGroupDTO implements Serializable{

	private static final long serialVersionUID =  7042388493728768554L;

	private Long id;

	/** 用户 */
	private Long userId;

	/** 组 */
	private Long groupId;

}
