package cn.metaq.data.mp.web;

import cn.metaq.common.web.dto.Result;
import cn.metaq.data.mp.biz.UserBiz;
import cn.metaq.data.mp.dto.UserDTO;
import cn.metaq.data.mp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserBiz userBiz;

  @PostMapping("users")
  public Result add(@RequestBody UserDTO userDTO){

    User user=new User();
    user.setName(userDTO.getName());
    userBiz.save(user);
    return Result.ok(user);
  }
}
