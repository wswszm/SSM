package com.web.service.impl;

import com.common.base.contants.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.dao.QuestionResRefMapper;
import com.web.dao.SysQuestionMapper;
import com.web.dao.SysResMapper;
import com.web.dao.SysResPathMapper;
import com.web.entity.*;
import com.web.service.SysResService;
import com.web.vo.QuestionVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/2
 */
@Service
public class SysResServiceImpl implements SysResService {

    @Resource
    private SysResMapper sysResMapper;
    @Resource
    private SysResPathMapper sysResPathMapper;
    @Resource
    private SysQuestionMapper sysQuestionMapper;
    @Resource
    private QuestionResRefMapper questionResRefMapper;

    @Override
    public Map<String, Object> save(MultipartFile file, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String dirPath = Constants.uploadFilePath + File.separator +
                new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dirFile = new File(realPath + dirPath);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID() + ext;
        File targetFile = new File(realPath + dirPath + File.separator + fileName);
        try {
            if(!targetFile.exists()){
                targetFile.createNewFile();
            }
            file.transferTo(targetFile);
            String targetFilePath =
                    targetFile.getAbsolutePath().substring(targetFile.getAbsolutePath().lastIndexOf(Constants.uploadFilePath));
            SysResPath sysResPath = new SysResPath();
            sysResPath.setResName(file.getOriginalFilename());
            sysResPath.setResPath(targetFilePath);
            sysResPathMapper.insertSelective(sysResPath);
            Map<String, Object> data = new HashMap<>();
            data.put("sysResPath", sysResPath);
            result.put("data", data);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        result.put("code","200");
        result.put("message","成功");
        return result;
    }

    @Override
    public Map<String, Object> selectList(SysRes res, Integer pageNo, Integer pageSize) {
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = Integer.MAX_VALUE;
        }
        PageHelper.startPage(pageNo,pageSize);
        List<SysRes> resList = sysResMapper.select(res);
        PageInfo<SysRes> pageInfo = new PageInfo<SysRes>(resList);
        List<ResVo> voList = new ArrayList<>();
        for(SysRes sysRes:resList){
            ResVo vo = new ResVo();
            vo.setRes(sysRes);
            vo.setResPath(sysResPathMapper.selectByPrimaryKey(sysRes.getResPathId()));
            vo.setSysImgPath(sysResPathMapper.selectByPrimaryKey(sysRes.getImgPathId()));
            voList.add(vo);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("resList", voList);
        data.put("totalCount",pageInfo.getTotal());
        Map<String, Object> result = new HashMap<>();
        result.put("code","200");
        result.put("message","成功");
        result.put("data", data);
        return result;
    }

    @Override
    public Map<String, Object> update(SysRes res, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        sysResMapper.updateByPrimaryKey(res);
        result.put("code","200");
        result.put("message","成功");
        return result;
    }

    @Override
    public Map<String, Object> saveResRef(Integer loginUserId, String resIds, String questionName, String content, Integer questionId) {
        Map<String, Object> result = new HashMap<>();
        if(questionId == null){
            SysQuestion question = new SysQuestion();
            question.setContent(content);
            question.setCreateBy(loginUserId);
            question.setIsDel("0");
            question.setQuestionName(questionName);
            sysQuestionMapper.insert(question);
            questionId = question.getId();
        }
        QuestionResRef questionResRef = new QuestionResRef();
        questionResRef.setQuestionId(questionId);
        questionResRefMapper.delete(questionResRef);
        if(resIds != null){
            for(String resId:resIds.split(",")){
                QuestionResRef ref = new QuestionResRef();
                ref.setQuestionId(questionId);
                ref.setResId(Integer.valueOf(resId));
                questionResRefMapper.insert(ref);
            }
        }
        result.put("code","200");
        result.put("message","成功");
        return result;
    }

    @Override
    public Map<String, Object> findResRefList(Integer loginUserId, String questionName, Integer pageNo, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        SysQuestion sysQuestion = new SysQuestion();
        sysQuestion.setCreateBy(loginUserId);
        sysQuestion.setIsDel("0");
        if(pageNo == null) pageNo = 1;
        if( pageSize == null ) pageSize = Integer.MAX_VALUE;
        PageHelper.startPage(pageNo,pageSize);
        List<SysQuestion> list = sysQuestionMapper.select(sysQuestion);
        PageInfo<SysQuestion> pageInfo = new PageInfo<SysQuestion>(list);
        List<QuestionVo> voList = new ArrayList<>();
        list.forEach(question ->{
            QuestionVo vo = new QuestionVo();
            vo.setQuestion(question);
            QuestionResRef ref = new QuestionResRef();
            ref.setQuestionId(question.getId());
            List<QuestionResRef> refList = questionResRefMapper.select(ref);
            List<SysRes> resList = new ArrayList<>();
            refList.forEach(r->{
                resList.add(sysResMapper.selectByPrimaryKey(r.getResId()));
            });
            vo.setResList(resList);
        });
        Map<String, Object> data = new HashMap<>();
        data.put("voList",voList);
        data.put("totalCount",pageInfo.getTotal());
        result.put("code","200");
        result.put("message","成功");
        result.put("data",data);
        return result;
    }

    @Override
    public Map<String, Object> delQuestion(Integer loginUserId, Integer questionId) {
        Map<String, Object> result = new HashMap<>();
        SysQuestion question = new SysQuestion();
        question.setId(questionId);
        question.setIsDel("1");
        sysQuestionMapper.updateByPrimaryKey(question);
        result.put("code","200");
        result.put("message","成功");
        return result;
    }

    @Override
    public SysRes get(String id) {
        return sysResMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysResPath getResPath(String id) {
        return sysResPathMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> saveRes(SysRes res) {
        Map<String, Object> result = new HashMap<>();
        sysResMapper.insertSelective(res);
        result.put("code","200");
        result.put("message","成功");
        return result;
    }
}
