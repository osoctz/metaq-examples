package cn.metaq.example.jpa.biz.impl;

import cn.metaq.example.jpa.biz.UserBiz;
import cn.metaq.example.jpa.model.dto.GroupDTO;
import cn.metaq.example.jpa.model.dto.RoleDTO;
import cn.metaq.example.jpa.model.dto.UserDTO;
import cn.metaq.example.jpa.model.entity.QGroup;
import cn.metaq.example.jpa.model.entity.QRole;
import cn.metaq.example.jpa.model.entity.QUser;
import cn.metaq.example.jpa.model.entity.QUserGroup;
import cn.metaq.example.jpa.model.entity.QUserRole;
import cn.metaq.example.jpa.model.entity.User;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class UserBizImplTest {

  @Autowired
  private JPAQueryFactory jqf;

  @Autowired
  private UserBiz userBiz;

  @Test
  public void unionDslQuery() {

    QUser user = QUser.user;
    QGroup group = QGroup.group;
    QUserGroup userGroup = QUserGroup.userGroup;

    List<User> users = jqf.select(user)
        .from(user)
        .leftJoin(userGroup)
        .on(user.id.eq(userGroup.userId))
        .leftJoin(group)
        .on(group.id.eq(userGroup.groupId))
        .where(user.username.eq("admin"))
        .fetch();

    System.out.println(users);
  }


  @Test
  public void customUnionDslQuery() {

    QUser user = QUser.user;
    QGroup group = QGroup.group;
    QUserGroup userGroup = QUserGroup.userGroup;

    List<UserDTO> users = jqf.select(Projections.fields(UserDTO.class,user.id,user.username,Projections.bean(GroupDTO.class,group.id)))
        .from(user)
        .leftJoin(userGroup)
        .on(user.id.eq(userGroup.userId))
        .leftJoin(group)
        .on(group.id.eq(userGroup.groupId))
        .where(user.username.eq("admin"))
        .fetch();

    System.out.println(users);
  }

  @Test
  public void one_to_many(){

    QRole role=QRole.role;
    QUserRole userRole=QUserRole.userRole;
    QUser user=QUser.user;

    List users=jqf.select(Projections.constructor(UserDTO.class,user.id,user.username,Projections.bean(RoleDTO.class,role.id,role.name)))
        .from(user)
        .leftJoin(userRole)
        .on(user.id.eq(userRole.userId))
        .leftJoin(role)
        .on(role.id.eq(userRole.roleId))
        .fetch();

    log.info(users);
  }

  @Test
  public void save(){

    User user=new User();

    user.setEmail("#Functions.checkNull(#name) && (#Functions.checkNull(#tags) || #Functions.compareTo(#createdTs, #updatedTs))?#Functions.skipRow(#row):#Functions.tagRow(#row)");
    userBiz.save(user);
  }
}