package cn.metaq.auth.security.web;

import cn.metaq.common.web.dto.Result;
import cn.metaq.uaa.provider.domain.CustomUserDetails;
import cn.metaq.uaa.security.JwtAuthenticationRequest;
import cn.metaq.uaa.security.TokenHelper;
import cn.metaq.uaa.security.UserTokenState;
import org.springframework.http.MediaType;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * LoginController
 *
 * @author tz
 * @date 2020/11/20 下午2:37
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenHelper tokenHelper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<UserTokenState> login(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException, IOException {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        String jws = tokenHelper.generateToken(user.getUsername(), device);
        int expiresIn = tokenHelper.getExpiredIn(device);

        return Result.ok(new UserTokenState(jws, expiresIn));
    }
}
