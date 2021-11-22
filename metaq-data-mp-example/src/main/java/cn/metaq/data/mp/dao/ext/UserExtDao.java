package cn.metaq.data.mp.dao.ext;

import cn.metaq.data.mp.dto.UserDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserExtDao {

  List<UserDTO> list();
}
