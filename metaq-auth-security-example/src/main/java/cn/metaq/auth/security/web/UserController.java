package cn.metaq.auth.security.web;

import cn.metaq.auth.security.biz.UserBiz;
import cn.metaq.auth.security.entity.User;
import cn.metaq.auth.security.userdetails.CustomUserDetailsService;
import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.core.qo.QueryWrapper;
import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.dto.Result;
import cn.metaq.uaa.provider.domain.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author tz
 * @date 2020/11/20 下午5:45
 * @since 1.0
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController<UserBiz> {

    @Resource
    private CustomUserDetailsService userDetailsService;

    @PostMapping("pages")
    public Pagination<User> list(@RequestBody QueryWrapper query, int offset, int limit) {

        return baseBiz.list(User.class,query, offset, limit);
    }

    @PostMapping
    public Result<String> add(@RequestBody User user) {
        baseBiz.save(user);
        return Result.ok();
    }

    @GetMapping("current")
    public CustomUserDetails current() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (CustomUserDetails) authentication.getPrincipal();
    }

    @GetMapping("chgPwd")
    public Result<String> passwd(String oldPassword, String newPassword) {

        userDetailsService.changePassword(oldPassword, newPassword);

        return Result.ok();
    }
}
