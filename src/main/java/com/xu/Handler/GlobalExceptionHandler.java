package com.xu.Handler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xu.Exception.TokenAuthExpiredException;
public class GlobalExceptionHandler {
    /**
     * 用户 token 过期
     * @return
     */
    @ExceptionHandler(value = TokenAuthExpiredException.class)
    @ResponseBody
    public String tokenExpiredExceptionHandler(){
        System.out.println("用户 token 过期");
        return "用户 token 过期";
    }
}

