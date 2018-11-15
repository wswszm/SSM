package com.web.entity;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/14
 */
public class ResVo {
    private SysRes res;
    private SysResPath resPath;
    private SysResPath sysImgPath;

    public SysRes getRes() {
        return res;
    }

    public void setRes(SysRes res) {
        this.res = res;
    }

    public SysResPath getResPath() {
        return resPath;
    }

    public void setResPath(SysResPath resPath) {
        this.resPath = resPath;
    }

    public SysResPath getSysImgPath() {
        return sysImgPath;
    }

    public void setSysImgPath(SysResPath sysImgPath) {
        this.sysImgPath = sysImgPath;
    }
}
