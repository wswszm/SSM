package com.common.base.contants;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Map;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/2
 */
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;
    private final static int successCode = 200;
    private final static int failCode = 0;
    public  Result(Boolean success, String msg, Object result){
        if(success){
            this.code = successCode;
        }else{
            this.code = failCode;
        }
        this.message = msg;
        this.data = result;
    }
}
