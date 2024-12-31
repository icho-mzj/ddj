package com.ddj.service.auth;

import com.ddj.common.constant.UserConstants;
import com.ddj.common.utils.StringUtils;
import com.ddj.entity.auth.SysRole;
import com.ddj.entity.auth.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: icho
 * @Date: 2024/10/9 19:12
 * @Describe:
 */
@Service
public class SysPermissionService {

    @Autowired
    private SysRoleService roleService;

//    @Autowired
//    private SysMenuService menuService;

    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(SysUser user)
    {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin())
        {
            roles.add("admin");
        }
        else
        {
            roles.addAll(roleService.selectRolePermissionByUserId(user.getUserId()));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
//    public Set<String> getMenuPermission(SysUser user)
//    {
//        Set<String> perms = new HashSet<String>();
//        // 管理员拥有所有权限
//        if (user.isAdmin())
//        {
//            perms.add("*:*:*");
//        }
//        else
//        {
//            List<SysRole> roles = user.getRoles();
//            if (!CollectionUtils.isEmpty(roles))
//            {
//                // 多角色设置permissions属性，以便数据权限匹配权限
//                for (SysRole role : roles)
//                {
//                    if (StringUtils.equals(role.getStatus(), UserConstants.ROLE_NORMAL))
//                    {
//                        Set<String> rolePerms = menuService.selectMenuPermsByRoleId(role.getRoleId());
//                        role.setPermissions(rolePerms);
//                        perms.addAll(rolePerms);
//                    }
//                }
//            }
//            else
//            {
//                perms.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
//            }
//        }
//        return perms;
//    }
}
