package cn.metaq.example.jpa.biz.impl;

import cn.metaq.example.jpa.biz.UserBiz;
import cn.metaq.example.jpa.dto.UserDTO;
import cn.metaq.example.jpa.entity.User;
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

    /**
     * 单表查询
     */
    @Test
    public void testFindAll() {

        List<User> userDTOList = userBiz.list(User.class);

        Assert.assertEquals(userDTOList.size(), 1);
    }


    @Test
    public void testListUserByRole() {

        List<UserDTO> userDTOList = userBiz.listUserByRole("admin");

        Assert.assertEquals(userDTOList.size(), 1);
    }
}