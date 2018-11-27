package com.web.service;

import com.web.entity.QuestionResRef;
import com.web.entity.SysQuestion;
import com.web.entity.SysRes;
import com.web.entity.SysResPath;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SysResService {
    Map<String, Object> save(MultipartFile file, HttpServletRequest request);

    Map<String, Object> selectList(SysRes res, Integer pageNo, Integer pageSize);

    Map<String, Object> update(SysRes res, HttpServletRequest request);

    Map<String, Object> saveResRef(Integer userId, String resIds, String questionName, String content,Integer questionId);

    Map<String, Object> findResRefList(Integer loginUserId, String questionName, Integer pageNo, Integer pageSize, String isDel);

    Map<String, Object> delQuestion(SysQuestion question);

    SysRes get(Integer id);

    SysResPath getResPath(Integer id);

    Map<String, Object> saveRes(SysRes res);

    Map<String, Object> getStatisticsByDay();

    List<QuestionResRef> findList(QuestionResRef questionResRef);
}
