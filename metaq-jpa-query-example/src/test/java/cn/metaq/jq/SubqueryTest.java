package cn.metaq.jq;

import cn.metaq.jq.dao.GroupDao;
import cn.metaq.jq.dao.TableDefinitionDao;
import cn.metaq.jq.dao.UserDao;
import cn.metaq.jq.entity.Group;
import cn.metaq.jq.entity.TableDefinition;
import cn.metaq.jq.entity.User;

import cn.metaq.jq.entity.UserGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class SubqueryTest {

    @Autowired
    private UserDao dao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private TableDefinitionDao tableDefinitionDao;
    @Test
    public void testSubQuery() {

        User user= dao.findById(1146827179511786l).get();
        String parentIds=user.getUserGroup().getGroupParentIds();
        List<User> users = dao.findAll(((root, cq, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

//            Join<User, Group> groupJoin = root.join("group", JoinType.LEFT);

//      cq.where(cb.equal(groupJoin.get("type"),0));
            predicates.add(cb.equal(cb.substring(root.get("userGroup").get("groupParentIds"),1,parentIds.length()),parentIds));
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        }));

        System.out.println(users.size());
    }

    @Test
    public void testGroupQuery() {

        User user= dao.findById(1146826331049962l).get();
//        Group group = groupDao.findById(1l).get();

//        for(UserGroup ug:user.getUserGroup()){
//            System.out.println(ug.getGroupId());
//        }
        System.out.println(user.getUserGroup().getGroupId());
//        System.out.println(children(group));
    }

    public List<Long> children(Group group) {
        List<Long> children = new ArrayList<>();
        if (group.getChildren() != null) {
            for (Group g : group.getChildren()) {
                children.add(g.getId());
                children.addAll(children(g));
            }
        }
        return children;
    }

    @Test
    public void testParent(){

        Group group = groupDao.findById(4l).get();
        List<Long> parentIds=new ArrayList<>();
        while(group.getParent()!=null){

            parentIds.add(group.getParent().getId());
            group=group.getParent();
        }

        Collections.reverse(parentIds);
        System.out.println(parentIds.stream().map(s->s+"").collect(Collectors.joining(";"))+";");
    }



    @Test
    public void testTableDefinition(){

        TableDefinition td=tableDefinitionDao.findById(1147877426352003l).get();

        System.out.println(td.getUser());
    }
}
