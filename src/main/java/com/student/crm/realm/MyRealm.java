package com.student.crm.realm;

import com.student.crm.domain.Employee;
import com.student.crm.domain.Role;
import com.student.crm.service.IEmployeeService;
import com.student.crm.service.IPermissionService;
import com.student.crm.service.IRoleService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;


public class MyRealm extends AuthorizingRealm {
    @Setter
    private IEmployeeService employeeService;
    @Setter
    private IRoleService roleService;
    @Setter
    private IPermissionService permissionService;
    @Override
    public String getName() {
        return "MyRealm";
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        /*使用当前的用户名来查询对象*/
        Employee currentUser = employeeService.queryByUsername(username);
        if (currentUser == null) {
            return null;
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(currentUser,currentUser.getPassword(),getName());
        return info;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Employee currentUser  = (Employee) principals.getPrimaryPrincipal();
        // roles 集合和 permissions 集合
        List<String> roles = null;
        List<String> permissions = null;
        // 判断是否是超级管理员
        if (currentUser.isAdmin()) {
            List<Role> roleList = roleService.selectAll();
            for (Role role : roleList) {
                roles = new ArrayList<>();
                roles.add(role.getSn());
            }
            permissions = new ArrayList<>();
            permissions.add("*:*");
        } else {
            roles = roleService.queryRolesByEmpId(currentUser.getId());
            permissions = permissionService.queryPermissionsByEmpId(currentUser.getId());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
    }
}
