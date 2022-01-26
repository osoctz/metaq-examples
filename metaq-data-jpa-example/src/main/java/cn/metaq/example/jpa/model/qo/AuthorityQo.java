package cn.metaq.example.jpa.model.qo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Date: Tue Nov 30 11:30:29 CST 2021.</p>
 * <p>授权.</p>
 *
 * @author zantang
 */
@Setter
@Getter
public class AuthorityQo implements Serializable{

	private static final long serialVersionUID =  7740605777223306791L;

	private Long id;

	/** 资源 */
	private Long resourceId;

	/** 授权 */
	private String authority;

}
