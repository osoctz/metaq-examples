package cn.metaq.uaa.provider.domain;

import cn.metaq.identity.model.entity.User;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * CustomUserDetails
 *
 * @author tz
 * @date 2020/11/20 下午1:10
 * @since 1.0
 */
@Setter
@Getter
public class CustomUserDetails implements UserDetails {

  private Date LastPasswordResetDate;

  private String name;
  private String username;
  private String password;
  private boolean enabled;
  private String groupParentIds;
  private User userObject;

  private Set<CustomGrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
