package com.center.pmit.project.common.web.controller;

import static com.center.pmit.project.common.constant.CustomResult.RETURN_RESULT_STATUS_CODE_BAD_REQUEST;
import static com.center.pmit.project.common.constant.CustomResult.RETURN_RESULT_STATUS_CODE_SERVER_EXCEPTION;

import com.center.pmit.project.common.util.JsonUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * 返回JSON结果和状态信息
 *
 * @author Administrator
 */
public abstract class AbstractCustomResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 接口同步返回数据,封装成json格式
     *
     * @param code  状态码
     * @param result success状态
     * @param message 返回信息
     * @param description 返回信息描述
     * @param obj 返回数据
     *
     * @return json格式数据
     */
    public static String returnToResult(String code, boolean result, String message, String description, Object obj) {
        Map<String, Object> resultMap = new HashMap<>(6);
        resultMap.put("code", code);
        resultMap.put("description", description);
        resultMap.put("data", obj);
        resultMap.put("success", result);
        resultMap.put("message", message);
        return JsonUtils.toJSON(resultMap);
    }


    /**
     * 接口异步返回数据,封装成json格式
     *
     * @param code  状态码
     * @param result 返回数据
     * @param message 返回信息
     * @param description 返回信息描述
     * @param obj success状态
     *
     * @return json格式数据
     */
    public static Callable<Object> returnToCallable(int code, Object result, String message, String description, boolean obj) {
        Map<String, Object> resultMap = new HashMap<>(6);
        resultMap.put("code", code);
        resultMap.put("data", result);
        resultMap.put("description", description);
        resultMap.put("message", message);
        resultMap.put("success", obj);
        return () -> JsonUtils.toJSON(resultMap);
    }

    /**
     * 服务器内部异常返回数据
     * @param message 错误描述
     * @param description 错误方法
     * @return json格式数据
     */
    public static Callable<Object> returnServerException(String message, String description) {
        Map<String, Object> resultMap = new HashMap<>(6);
        resultMap.put("code", RETURN_RESULT_STATUS_CODE_SERVER_EXCEPTION);
        resultMap.put("data", null);
        resultMap.put("description", description);
        resultMap.put("message", message);
        resultMap.put("success", false);
        return () -> JsonUtils.toJSON(resultMap);
    }



    /**
     * 传入参数为Null的返回状态
     * @return json格式数据
     */
    public static Callable<Object> returnIsNullError() {
        Map<String, Object> resultMap = new HashMap<>(6);
        resultMap.put("code", RETURN_RESULT_STATUS_CODE_BAD_REQUEST);
        resultMap.put("data", null);
        resultMap.put("description", "请求参数为null");
        resultMap.put("message", "传入参数不能为null");
        resultMap.put("success", false);
        return () -> JsonUtils.toJSON(resultMap);
    }


    /**
     * 全局异常返回状态
     * @return json格式数据
     */
    public static Callable<Object> returnGlobalException(int code, String description,String message) {
        Map<String, Object> resultMap = new HashMap<>(6);
        resultMap.put("code", code);
        resultMap.put("data", null);
        resultMap.put("description", description);
        resultMap.put("message", message);
        resultMap.put("success", false);
        return () -> JsonUtils.toJSON(resultMap);
    }


    /**
     * 接口成功，返回数据
     *
     * @param obj 返回数据
     *
     * @return json格式数据
     */
    public static String returnToResult(int code, Object obj) {
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("code", code);
        resultMap.put("data", obj);
        return JsonUtils.toJSON(resultMap);
    }
}
