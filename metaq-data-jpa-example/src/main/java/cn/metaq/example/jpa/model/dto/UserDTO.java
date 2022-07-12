package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>用户.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class UserDTO implements Serializable{

	private static final long serialVersionUID =  1369787912945961865L;

	private Long id;

	/** 用户名 */
	private String username;

	private List<RoleDTO> roles;

//	private List<GroupDTO> groups;

	public UserDTO() {
	}

//	public UserDTO(Long id, String username) {
//		this.id = id;
//		this.username = username;
//	}

	public UserDTO(Long id, String username, List<RoleDTO> roles) {
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
}
