package com.ddj.entity.auth;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2024/10/9 16:07
 * @Describe: 用户登录对象
 */
@Data
public class LoginBody {

    private String username;
    private String password;
    private String code; // 验证码
    private String uuid;
}
