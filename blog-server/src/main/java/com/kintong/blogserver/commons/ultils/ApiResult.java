package com.kintong.blogserver.commons.ultils;

import com.alibaba.fastjson2.JSON;
import com.kintong.blogserver.commons.ApiCode;

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

    public static <T> ApiResult<T> fail(ApiCode apiCode){
        return new ApiResult<>(apiCode.getCode(),null,apiCode.getMessage());
    }

    public String toJsonString(){
        return JSON.toJSONString(this);
    }
}
