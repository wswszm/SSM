package com.web.controller;

import com.alibaba.druid.util.StringUtils;
import com.common.base.contants.Constants;
import com.common.base.contants.Result;
import com.web.entity.User;
import com.web.entity.UserDto;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/10/29
 */
@RestController
@RequestMapping("/res/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findById")
    public Map<String, Object> findById(Integer id){
        Map<String, Object> result = new HashMap<>();
        User user = userService.getUserById(id);
        result.put("user", user);
        return result;
    }
    @RequestMapping("login")
    public Map<String, Object> login(HttpServletRequest req, HttpServletResponse rsp, String userName, String password){
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = userService.login(req, userName, password);
        result.put("code", 200);
        result.put("message", "success");
        result.put("data",data);
        return result;
    }
    @RequestMapping("logout")
    public Map<String, Object>logout(HttpServletRequest req){
        Map<String, Object> result = new HashMap<>();
        req.getSession().removeAttribute(Constants.sessionId);
        result.put("code", 200);
        result.put("message", "success");
        return result;
    }
    @RequestMapping("regist")
    public Map<String, Object> regist(@RequestBody UserDto dto){
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        if(!StringUtils.isEmpty(dto.getEmail())){user.setEmail(dto.getEmail());} else user.setEmail("");
        if(!StringUtils.isEmpty(dto.getMobile()))user.setMobile(dto.getMobile()); else user.setMobile("");
        if(dto.getSex() != null)user.setSex(dto.getSex()); else user.setSex(0);
        user.setCreateTime(new Date());
        return userService.save(user, dto.getRoleType());
    }
    @RequestMapping("userList")
    public Map<String, Object> userList(){
        return userService.selectList();
    }
    @RequestMapping("update")
    public Map<String, Object>update(User user){
        return userService.update(user);
    }
}
