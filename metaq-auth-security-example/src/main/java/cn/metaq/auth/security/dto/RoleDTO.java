package cn.metaq.auth.security.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

/**
 * RoleDTO
 *
 * @author tz
 * @date 2020/11/27 下午1:33
 * @since 1.0
 */
@Setter
@Getter
public class RoleDTO implements IDto {

    private String name;
    private String code;
}
