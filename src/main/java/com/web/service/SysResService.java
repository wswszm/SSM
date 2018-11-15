package com.web.service;

import com.web.entity.SysRes;
import com.web.entity.SysResPath;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SysResService {
    Map<String, Object> save(MultipartFile file, HttpServletRequest request);

    Map<String, Object> selectList(SysRes res, Integer pageNo, Integer pageSize);

    Map<String, Object> update(SysRes res, HttpServletRequest request);

    Map<String, Object> saveResRef(Integer userId, String resIds, String questionName, String content,Integer questionId);

    Map<String, Object> findResRefList(Integer loginUserId, String questionName, Integer pageNo, Integer pageSize);

    Map<String, Object> delQuestion(Integer loginUserId, Integer questionId);

    SysRes get(String id);

    SysResPath getResPath(String id);

    Map<String, Object> saveRes(SysRes res);
}
