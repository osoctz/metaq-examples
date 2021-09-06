package cn.metaq.data.mp.biz;

import cn.metaq.data.mp.entity.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class UserBizTest {

    @Autowired
    private UserBiz userBiz;

    @Test
    public void testLoadAllUsers(){

        List<User> users=userBiz.list(User.class);
        log.info(users);
        Assert.assertEquals(1,users.size());
    }
}
