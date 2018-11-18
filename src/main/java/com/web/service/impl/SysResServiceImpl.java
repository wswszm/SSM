package com.web.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.common.base.contants.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.dao.*;
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
    @Resource
    private StatisticsMapper statisticsMapper;

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
        PageHelper.startPage(pageNo,pageSize, "create_date desc");
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
        sysResMapper.updateByPrimaryKeySelective(res);
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
            question.setCreateDate(new Date());
            sysQuestionMapper.insertSelective(question);
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
        if(!StringUtils.isEmpty(questionName)){
            sysQuestion.setQuestionName(questionName);
        }
        sysQuestion.setIsDel("0");
        if(pageNo == null) pageNo = 1;
        if( pageSize == null ) pageSize = Integer.MAX_VALUE;
        PageHelper.startPage(pageNo,pageSize,"create_date desc");
        List<SysQuestion> list = sysQuestionMapper.select(sysQuestion);
        PageInfo<SysQuestion> pageInfo = new PageInfo<SysQuestion>(list);
        List<QuestionVo> voList = new ArrayList<>();
        list.forEach(question ->{
            QuestionVo vo = new QuestionVo();
            vo.setQuestion(question);
            QuestionResRef ref = new QuestionResRef();
            ref.setQuestionId(question.getId());
            List<QuestionResRef> refList = questionResRefMapper.select(ref);
            List<Map<String, Object>> resList = new ArrayList<>();
            refList.forEach(r->{
                Map<String, Object> map = new HashMap<>();
                SysRes res = sysResMapper.selectByPrimaryKey(r.getResId());
                map.put("sysRes", res);
                map.put("resPath", sysResPathMapper.selectByPrimaryKey(res.getResPathId()));
                map.put("imgPath", sysResPathMapper.selectByPrimaryKey(res.getImgPathId()));
                resList.add(map);
            });
            vo.setResList(resList);
            voList.add(vo);
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
        sysQuestionMapper.updateByPrimaryKeySelective(question);
        result.put("code","200");
        result.put("message","成功");
        return result;
    }

    @Override
    public SysRes get(String id) {
        return sysResMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysResPath getResPath(Integer id) {
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

    @Override
    public Map<String, Object> getStatisticsByDay() {
        Map<String, Object> result = new HashMap<>();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1){
            dayOfWeek = 7;
        }
        c.add(Calendar.DATE, -dayOfWeek + 1);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for(int i = 1; i <= 7; i++){
            Map<String, Object>map = new HashMap<>();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            map.put("date", date);
            map.put("count", statisticsMapper.getCountByDay(date));
            resultList.add(map);
            c.add(Calendar.DATE , 1);
        }
        result.put("code","200");
        result.put("message","成功");
        result.put("resultList",resultList);
        return result;
    }
}
