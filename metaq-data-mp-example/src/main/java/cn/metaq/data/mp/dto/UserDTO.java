package cn.metaq.data.mp.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.junit.platform.commons.util.ToStringBuilder;
import org.springframework.core.style.ToStringStyler;

@Setter
@Getter
public class UserDTO {

  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * 登录名
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 最近密码重置时间
   */
  private java.util.Date lastPasswordResetDate;

  /**
   * 是否启用 0-启用 1-禁用
   */
  private Long enabled;

  private List<RoleDTO> roles;

}
