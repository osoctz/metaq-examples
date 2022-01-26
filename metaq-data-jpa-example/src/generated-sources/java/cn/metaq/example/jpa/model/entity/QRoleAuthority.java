package cn.metaq.example.jpa.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoleAuthority is a Querydsl query type for RoleAuthority
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleAuthority extends EntityPathBase<RoleAuthority> {

    private static final long serialVersionUID = -112374045L;

    public static final QRoleAuthority roleAuthority = new QRoleAuthority("roleAuthority");

    public final NumberPath<Long> authorityId = createNumber("authorityId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public QRoleAuthority(String variable) {
        super(RoleAuthority.class, forVariable(variable));
    }

    public QRoleAuthority(Path<? extends RoleAuthority> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleAuthority(PathMetadata metadata) {
        super(RoleAuthority.class, metadata);
    }

}

