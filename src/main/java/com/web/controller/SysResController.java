package com.web.controller;

import com.common.base.contants.Constants;
import com.common.uitls.DownloadUtils;
import com.web.dao.SysResPathMapper;
import com.web.entity.*;
import com.web.service.SysResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/2
 */
@Controller
@RequestMapping("/res/sys_res")
public class SysResController {

    private LoginUser getLoginUser(HttpServletRequest request) {
        return (LoginUser) request.getSession().getAttribute(Constants.sessionId);
    }

    private Integer getLoginUserId(HttpServletRequest request) {
        return ((LoginUser) request.getSession().getAttribute(Constants.sessionId)).getUser().getId();
    }

    @Autowired
    private SysResService sysResService;

    /*@RequestMapping("save")
    @ResponseBody
    public Map<String, Object> save(HttpServletRequest request,@RequestBody SysRes res, MultipartFile file, MultipartFile imgFile) {
        res.setCreatorId(getLoginUserId(request));
        return sysResService.save(file, request);
    }*/

    @RequestMapping("selectListByCreateorId")
    @ResponseBody
    public Map<String, Object> selectListByCreateorId(HttpServletRequest request,
                                                      @RequestBody SysRes res,
                                                      @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                                      @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        //res.setCreatorId(getLoginUserId(request));
        return sysResService.selectList(res, pageNo, pageSize);
    }
    @RequestMapping("selectList")
    @ResponseBody
    public Map<String, Object> selectList(HttpServletRequest request,@RequestBody SysRes res, Integer pageNo, Integer pageSize) {
        return sysResService.selectList(res, pageNo, pageSize);
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request,@RequestBody SysRes res) {
        //res.setCreatorId(getLoginUserId(request));
        return sysResService.update(res, request);
    }
   /* @RequestMapping("upload")
    public Map<String, Object> upload(HttpServletRequest request, SysRes res, MultipartFile file) throws IOException {
        File targetFile = new File("/Users/zhaomeng/Downloads/111/1.pdf");
        targetFile.createNewFile();
        file.transferTo(targetFile);
        return null;
    }*/
    @RequestMapping("saveResRef")
    @ResponseBody
    public Map<String, Object> saveResRef(@RequestBody SysResRefSaveDto dto){
        return sysResService.saveResRef(dto.getUserId(), dto.getResIds(), dto.getQuestionName(), dto.getContent(), dto.getQuestionId());
    }
    @RequestMapping("findResRefList")
    @ResponseBody
    public Map<String, Object> findResRefList(@RequestBody findResRefDto dto){
        return sysResService.findResRefList(dto.getUserId(), dto.getQuestionName(), dto.getPageNo(), dto.getPageSize(),dto.getIsDel());
    }
    @RequestMapping("delQuestion")
    @ResponseBody
    public Map<String, Object> delQuestion(@RequestBody SysQuestion question){
        return sysResService.delQuestion(question);
    }
    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> uploadRes(HttpServletRequest request, MultipartFile file){
        return sysResService.save(file,request);
    }
    @RequestMapping("saveRes")
    @ResponseBody
    public Map<String, Object> saveRes(@RequestBody SysRes res, HttpServletRequest request){
        //res.setCreatorId(getLoginUserId(request));
        res.setAuditStatus("0");
        res.setIsDel("0");
        return sysResService.saveRes(res);
    }

    @RequestMapping("downloadZip")
    public void downloadZip(HttpServletRequest request, HttpServletResponse response, Integer id){
        if(StringUtils.isEmpty(id)){
            return;
        }
        QuestionResRef questionResRef = new QuestionResRef();
        questionResRef.setQuestionId(id);
        List<QuestionResRef> list = sysResService.findList(questionResRef);
        List<String> filePathList = new ArrayList<>();
        List<String> fileNameList = new ArrayList<>();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        for(QuestionResRef qResRef:list){
            SysRes sysRes = sysResService.get(qResRef.getResId());
            SysResPath sysResPath = sysResService.getResPath(sysRes.getResPathId());
            filePathList.add(realPath + sysResPath.getResPath());
            fileNameList.add(sysRes.getResName());

        }
        DownloadUtils.batchDownLoadFile(request, response,"question",
                filePathList.toArray(new String[filePathList.size()]),
                fileNameList.toArray(new String[fileNameList.size()]));
        return ;
    }
    @RequestMapping("getStatisticsByDay")
    @ResponseBody
    public Map<String, Object> getStatisticsByDay(){
        return sysResService.getStatisticsByDay();
    }
}
