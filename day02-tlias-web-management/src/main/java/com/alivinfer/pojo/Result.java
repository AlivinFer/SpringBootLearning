package com.alivinfer.pojo;

import lombok.Data;

/**
 * @author Fer
 * @version 1.0
 * @description 后端统一返回结果
 * @date 2025/4/24
 */

@Data
public class Result {

    /**
     * 编码 1：成功 0：失败
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    /**
     * 创建一个表示成功的 Result 对象
     *
     * @return 返回一个表示成功的 Result 对象
     */
    public static Result success() {
        Result result = new Result();

        // 设置成功代码
        result.code = 1;

        // 设置成功消息
        result.msg = "success";

        // 返回表示成功的Result对象
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
