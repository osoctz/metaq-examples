package cn.metaq.data.jdbc.biz.impl;

import cn.metaq.data.jdbc.biz.UserBiz;
import cn.metaq.data.jdbc.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserBizImplTest {

    @Autowired
    private UserBiz userBiz;

    @Test
    public void testAll() {

        List<User> users = userBiz.list();

        Assert.assertEquals(2, users.size());
    }
}