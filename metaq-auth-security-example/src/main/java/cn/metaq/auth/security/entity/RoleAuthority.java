package cn.metaq.auth.security.entity;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * RoleAuthority
 *
 * @author tz
 * @date 2020/11/20 下午4:35
 * @since 1.0
 */
@Table(name = "role_authority")
@Entity
@Setter
@Getter
public class RoleAuthority implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "authority_id")
    private Long authorityId;
}
