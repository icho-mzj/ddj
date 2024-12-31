package com.ddj.service.auth;

import com.ddj.common.constant.UserConstants;
import com.ddj.common.security.context.AuthenticationContextHolder;
import com.ddj.common.exception.LogicException;
import com.ddj.common.exception.UserException;
import com.ddj.common.utils.DateUtils;
import com.ddj.common.utils.IpUtils;
import com.ddj.common.utils.StringUtils;
import com.ddj.entity.auth.LoginUser;
import com.ddj.entity.auth.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import javax.annotation.Resource;

/**
 * @Author: icho
 * @Date: 2024/10/9 16:28
 * @Describe:
 */
@Service
public class LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysUserService userService;


    public String login(String username, String password, String uuid) {
        // 验证码校验

        // 登录前置校验
        loginPreCheck(username, password);
        // 用户验证
        Authentication authentication = null;
        try
        {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            AuthenticationContextHolder.setContext(authenticationToken);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserException("user.password.not.match",null);
            }
            else
            {
                //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new LogicException(e.getMessage());
            }
        }
        finally
        {
            AuthenticationContextHolder.clearContext();
        }
        // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());

        // 生成token
        return tokenService.createToken(loginUser);
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(Long userId)
    {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr());
        sysUser.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(sysUser);
    }

    public void loginPreCheck(String username, String password)
    {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw new UserException("input.exists",null);
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserException("user.password.not.match",null);
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserException("user.password.retry.limit.exceed", null);
        }
        // IP黑名单校验
//        String blackStr = configService.selectConfigByKey("sys.login.blackIPList");
//        if (IpUtils.isMatchedIp(blackStr, IpUtils.getIpAddr())) {
//            //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("login.blocked")));
//            throw new BlackListException();
//        }
    }
}
