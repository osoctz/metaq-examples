package cn.metaq.example.jpa.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGroup is a Querydsl query type for Group
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGroup extends EntityPathBase<Group> {

    private static final long serialVersionUID = 1070682101L;

    public static final QGroup group = new QGroup("group1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final NumberPath<Integer> priority = createNumber("priority", Integer.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QGroup(String variable) {
        super(Group.class, forVariable(variable));
    }

    public QGroup(Path<? extends Group> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroup(PathMetadata metadata) {
        super(Group.class, metadata);
    }

}

