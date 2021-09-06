package cn.metaq.example.jpa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.example.jpa.biz.UserBiz;
import cn.metaq.example.jpa.dto.UserDTO;
import cn.metaq.example.jpa.dao.UserDao;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBizImpl extends BaseBiz<UserDTO, Long, UserDao> implements UserBiz {

    @Resource
    private BaseTemplate template;

    public List<UserDTO> listUserByRole(String roleCode) {
        String jql = "select new cn.metaq.example.jpa.dto.UserDTO(u.id," +
                "u.name," +
                "u.username," +
                "u.password," +
                "u.email," +
                "u.lastPasswordResetDate," +
                "u.enabled) from User u " +
                "left join UserRole ur on u.id=ur.userId " +
                "left join Role r on r.id=ur.roleId " +
                "where r.code=:roleCode";

        Map<String, Object> params = new HashMap<>();
        params.put("roleCode", roleCode);

        return template.list(UserDTO.class, jql, params);
    }

    @Override
    public Specification map(UserDTO userDTO) {
        return null;
    }
}
