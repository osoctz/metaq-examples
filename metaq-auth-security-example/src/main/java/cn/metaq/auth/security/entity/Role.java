package cn.metaq.auth.security.entity;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role
 *
 * @author tz
 * @date 2020/11/20 下午2:16
 * @since 1.0
 */
@Entity
@Table(name = "role")
@Setter
@Getter
public class Role implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    private String name;
    private String code;
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
