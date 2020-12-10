package com.abraham.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 操作结果工具类
 *
 * @author: Long
 * @date Create in 17:03 2020/12/8
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Result 对象
     */
    public Result() {
    }

    /**
     * 返回错误消息
     *
     * @param msg 错误信息内容
     * @return 错误消息
     */
    public static Result error(String msg)
    {
        Result map = new Result();
        map.put("msg", msg);
        map.put("code", 1);
        return map;
    }

    /**
     * 返回成功消息
     *
     * @param msg 成功信息内容
     * @return 成功消息
     */
    public static Result success(String msg)
    {
        Result map = new Result();
        map.put("msg", msg);
        map.put("code", 0);
        return map;
    }
}
