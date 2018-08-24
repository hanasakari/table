package com.table.core.shiro;

import com.table.dao.table.entity.TbUser;
import com.table.dao.table.entity.TbUserExample;
import com.table.dao.table.mapper.TbUserMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroRealm  extends AuthorizingRealm {
    @Autowired
    TbUserMapper tbUserMapper;
    @Override
    //@org.springframework.transaction.annotation.Transactional
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户
        //UserDto user = convertToDto(userDao.findUserByUsername((String)principalCollection.getPrimaryPrincipal()));
        //User currentUser = userDao.findUserByUsername((String)principalCollection.getPrimaryPrincipal());
        TbUser user = (TbUser) SecurityUtils.getSubject().getSession().getAttribute("user");

        //把principals放session中，key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(user.getTbUserId(),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
//        for(RoleDto role:user.getRoles()){
//            info.addRole(role.getName());
//        }
        info.addRole(user.getTbUserRole().toString());//之后搞个枚举或者写成sql
        //赋予权限
//        for(PermissionDto permission:user.getPermissions()){
//            //System.out.println(permission.getName());
//            info.addStringPermission(permission.getName());
//        }
        return info;
    }
    //登陆部分
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();

        TbUserExample tbUserExample = new TbUserExample();
        tbUserExample.createCriteria().andTbUserLoginNameEqualTo(userName);
        List<TbUser> users = tbUserMapper.selectByExample(tbUserExample);
        TbUser user = null;
        if (CollectionUtils.isNotEmpty(users))
            user = users.get(0);
        if(user != null){
            //登陆成功
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user",user);
            session.setAttribute("id",user.getTbUserId());
            session.setAttribute("username",user.getTbUserLoginName());
            session.setAttribute("name",user.getTbUserNickName());
            return new SimpleAuthenticationInfo(
                    userName, //用户
                    user.getTbUserPassword(), //密码
                    getName() //realm name
            );
        } else {
            throw new UnknownAccountException();
        }
    }
}
