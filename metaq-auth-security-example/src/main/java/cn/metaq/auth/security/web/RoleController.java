package cn.metaq.auth.security.web;

import cn.metaq.auth.security.biz.RoleBiz;
import cn.metaq.auth.security.dto.RoleDTO;
import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoleController
 *
 * @author tz
 * @date 2020/11/27 下午1:56
 * @since 1.0
 */
@RestController
@RequestMapping("roles")
public class RoleController extends BaseController<RoleBiz> {

    @PostMapping("pages")
    public Pagination<RoleDTO> list(@RequestBody(required = false) RoleDTO roleDTO, int offset, int limit) {

        return baseBiz.list(RoleDTO.class,roleDTO, offset, limit);
    }
}
