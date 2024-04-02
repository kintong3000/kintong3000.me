package com.kintong.blogserver.core.ultils;

import com.alibaba.fastjson2.JSON;
import com.kintong.blogserver.commons.consts.ApiCode;

/**
 * @Author kintong
 */
public record ApiResult<T> (int code,T data,String message) {

    public static <T> ApiResult<T> success(T data){
        return new ApiResult<>(ApiCode.SUCCESS.getCode(), data,ApiCode.SUCCESS.getMessage());
    }
    public static <T> ApiResult<T> success(){
        return success(null);
    }

    public static <T> ApiResult<T> failure(ApiCode apiCode){
        return new ApiResult<>(apiCode.getCode(),null,apiCode.getMessage());
    }

    public String toJsonString(){
        return JSON.toJSONString(this);
    }
}
