package cn.metaq.example.jpa.biz;

import cn.metaq.data.Biz;
import cn.metaq.example.jpa.dto.UserDTO;

import java.util.List;

/**
 *
 */
public interface UserBiz extends Biz<UserDTO, Long> {

    List<UserDTO> listUserByRole(String roleCode);
}
