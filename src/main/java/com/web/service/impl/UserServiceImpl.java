package com.web.service.impl;

import com.common.base.contants.Constants;
import com.github.pagehelper.PageHelper;
import com.web.dao.SysRoleMapper;
import com.web.dao.SysUserRoleMapper;
import com.web.dao.UserMapper;
import com.web.entity.LoginUser;
import com.web.entity.SysRole;
import com.web.entity.SysUserRole;
import com.web.entity.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/10/29
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;


    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> login(HttpServletRequest req, String userName, String password) {
        Map<String, Object>result = new HashMap<>();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        PageHelper.startPage(0,10);
        List<User> userList = userMapper.select(user);
        if(userList != null && userList.size() > 0){
            user = userList.get(0);
            result.put("user", user);
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(user.getId());
            List<SysUserRole>userRoleList = sysUserRoleMapper.select(userRole);
            if(userRoleList != null && userRoleList.size() > 0){
                userRole = userRoleList.get(0);
                SysRole role = sysRoleMapper.selectByPrimaryKey(userRole.getRoleId());
                LoginUser loginUser = new LoginUser();
                loginUser.setRole(role);
                loginUser.setUser(user);
                req.getSession().setAttribute(Constants.sessionId,loginUser);
                result.put("status", "1");
                result.put("role", role);
            }else{
                result.put("status","0");
                result.put("msg", "登录人角色缺失");
            }

        }else{
            result.put("status", "0");
            result.put("msg","登录名密码不正确");
        }


        return result;
    }

    @Override
    public Map<String, Object> save(User user, String roleType) {
        Map<String, Object> result = new HashMap<>();
        User checkUser = new User();
        checkUser.setUserName(user.getUserName());
        List<User> checkList = userMapper.select(checkUser);
        if(checkList.size() > 0){
            result.put("status", "0");
            result.put("msg", "用户名已存在");
            return result;
        }
        user.setIsDel("1");
        userMapper.insertSelective(user);
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(user.getId());
        sysUserRole.setRoleId(Integer.valueOf(roleType));
        sysUserRoleMapper.insertSelective(sysUserRole);
        result.put("status", "1");
        result.put("msg","成功");
        return result;
    }

    @Override
    public Map<String, Object> selectList() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        data.put("userList", userMapper.selectAll());
        result.put("status","1");
        result.put("msg","成功");
        result.put("data",data);
        return result;
    }

    @Override
    public Map<String, Object> update(User user) {
        Map<String, Object> result = new HashMap<>();
        userMapper.updateByPrimaryKey(user);
        result.put("status","1");
        result.put("msg","成功");
        return result;
    }
}
