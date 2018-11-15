package com.web.service;

import com.web.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/10/29
 */
public interface UserService {

    User getUserById(Integer id);
    Map<String, Object> login(HttpServletRequest req, String userName, String password);
    Map<String, Object> save(User user, String roleType);

    Map<String, Object> selectList();

    Map<String, Object> update(User user);
}
