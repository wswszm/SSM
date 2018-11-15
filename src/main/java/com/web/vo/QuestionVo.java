package com.web.vo;

import com.web.entity.SysQuestion;
import com.web.entity.SysRes;

import java.util.List;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/7
 */
public class QuestionVo {
    private SysQuestion question;
    private List<SysRes> resList;

    public SysQuestion getQuestion() {
        return question;
    }

    public void setQuestion(SysQuestion question) {
        this.question = question;
    }

    public List<SysRes> getResList() {
        return resList;
    }

    public void setResList(List<SysRes> resList) {
        this.resList = resList;
    }
}
