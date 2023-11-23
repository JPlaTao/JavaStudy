package com.platao.epilogue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String message;
    private Integer statusCode;
    private Object data;

    private static final Integer STATUS_SUCCESS = 1;
    private static final Integer STATUS_FAILURE = 0;

    public static Result success(String message){
        return new Result(message, STATUS_SUCCESS,null);
    }

    public static Result success(String message,Object data){
        return new Result(message,STATUS_SUCCESS,data);
    }

    public static Result failure(String message,Integer statusCode,Object data){
        return new Result(message,statusCode,data);
    }

    public static Result failure(String message){
        return new Result(message, STATUS_SUCCESS,null);
    }

    public static Result failure(String message,Object data){
        return new Result(message,STATUS_SUCCESS,data);
    }

}
