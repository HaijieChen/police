package org.zhajing.police.utils;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/26 16:18
 * @blame Middle Platform
 */
@Data
public class Result<T> {

    private String msg;
    private String code;
    private T data;
    private static final String SUCCESS_CODE="200";
    private static final String ERROR_CODE="404";
    private static final String SUCCESS_MSG="请求成功";
    private static final String ERROR_MSG="请求失败";



    public static Result<String> ok(){
        Result<String> result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        result.setData(Strings.EMPTY);
        return  result;
    }


    public static Result<String> e(){
        Result<String> result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(ERROR_MSG);
        result.setData(Strings.EMPTY);
        return  result;
    }

    public static Result<String> e(String code,String msg){
        Result<String> result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(Strings.EMPTY);
        return  result;
    }

    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        result.setData(data);
        return  result;
    }

    public static <T> Result<T> ok(T data,String code,String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
       return  result;
    }

}
