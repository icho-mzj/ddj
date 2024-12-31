package com.ddj.entity.auth;

import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2024/10/9 17:24
 * @Describe: 用户对象 sys_user
 */
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Getter
    private Long userId;

    /** 部门ID */
    @Getter
    private Long deptId;

    /** 用户账号 */
    @Getter
    private String userName;

    /** 用户昵称 */
    @Getter
    private String nickName;

    /** 用户邮箱 */
    @Getter
    private String email;

    /** 手机号码 */
    private String phonenumber;

    /** 用户性别 */
    @Getter
    private String sex;

    /** 用户头像 */
    @Getter
    private String avatar;

    /** 密码 */
    @Getter
    private String password;

    /** 帐号状态（0正常 1停用） */
    @Getter
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @Getter
    private String delFlag;

    /** 最后登录IP */
    @Getter
    private String loginIp;

    /** 最后登录时间 */
    @Getter
    private Date loginDate;

    /** 角色对象 */
    @Getter
    private List<SysRole> roles;

    /** 角色组 */
    @Getter
    private Long[] roleIds;

    /** 角色ID */
    @Getter
    private Long roleId;

    public SysUser()
    {

    }

    public SysUser(Long userId)
    {
        this.userId = userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }
    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("deptId", getDeptId())
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .append("email", getEmail())
                .append("phonenumber", getPhonenumber())
                .append("sex", getSex())
                .append("avatar", getAvatar())
                .append("password", getPassword())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("loginIp", getLoginIp())
                .append("loginDate", getLoginDate())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
