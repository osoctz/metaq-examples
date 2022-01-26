package cn.metaq.example.jpa.model.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:11 CST 2021.</p>
 * <p>授权.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class AuthorityDTO implements Serializable{

	private static final long serialVersionUID =  4245494562877354747L;

	private Long id;

	/** 资源 */
	private Long resourceId;

	/** 授权 */
	private String authority;

}
