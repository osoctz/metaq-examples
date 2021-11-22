package cn.metaq.data.mp.entity;

import cn.metaq.common.core.IEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName(value = "t_id_user")
public class User implements IEntity<Long> {

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
}
