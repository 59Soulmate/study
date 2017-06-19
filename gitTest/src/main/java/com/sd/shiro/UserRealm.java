package com.sd.shiro;

import java.util.HashSet;
import java.util.Set;

import com.sd.entity.ShiroToken;
import com.sd.entity.User;
import com.sd.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {
	@Autowired
	UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		ShiroToken token = (ShiroToken) SecurityUtils.getSubject().getPrincipal();
		String username = token.getUsername();
//		logger.info(username + "授权...");
		System.out.println(username+"授权...");
		// 从数据库中查找该用户的角色和权限
		SimpleAuthorizationInfo sainfo = new SimpleAuthorizationInfo();
		Set<String> roles = new HashSet<String>();
		roles.add("admin");
//		roles.add("role1");
		Set<String> permissions = new HashSet<String>();
		permissions.add("add");
		permissions.add("delete");
		sainfo.setRoles(roles);
		sainfo.setStringPermissions(permissions);
		return sainfo;
	}

	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		ShiroToken token = (ShiroToken) arg0;
		String username = token.getUsername();
		// 根据username从数据库查找用户，得到密码
		User user = userService.findUserByLogin(username);
		if (null == user) {
			throw new AccountException("username is not exist");
		} else if (!user.getUser_pass().equals(token.getPswd())) {
			throw new AccountException("password is not right");
		} else {
			System.out.println("登录成功" + username);
		}
		return new SimpleAuthenticationInfo(arg0, user.getUser_pass(), username);
	}

}
