package com.ddj.controller.auth;

import com.ddj.common.constant.Constants;
import com.ddj.common.constant.ResponseResult;
import com.ddj.common.utils.SecurityUtils;
import com.ddj.entity.auth.LoginBody;
import com.ddj.entity.auth.SysUser;
import com.ddj.service.auth.LoginService;
import com.ddj.service.auth.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Author: icho
 * @Date: 2024/10/9 16:05
 * @Describe:
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SysPermissionService permissionService;


    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginBody loginBody) {
        ResponseResult result = new ResponseResult();
        // 生成令牌
        String token = loginService.login(
                loginBody.getUsername(), loginBody.getPassword(),
                // loginBody.getCode(),
                loginBody.getUuid());
        result.put(Constants.TOKEN, token);
        return result;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public ResponseResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        ResponseResult result = ResponseResult.success();
        result.put("user", user);
        result.put("roles", roles);
        return result;
    }
}
