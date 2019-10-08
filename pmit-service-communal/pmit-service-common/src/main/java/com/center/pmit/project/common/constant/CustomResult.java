package com.center.pmit.project.common.constant;

/**
 * 返回基本信息常量类
 * @author Administrator
 */
public class CustomResult {

    /**
     * 请求成功
     */
    public final static int RETURN_RESULT_STATUS_CODE_SUCCESS = 200;


    /**
     * 服务器错误
     */
    public final static int RETURN_RESULT_STATUS_CODE_SERVER_EXCEPTION = 500;

    /**
     * 数据错误
     */
    public final static int RETURN_RESULT_STATUS_CODE_BAD_REQUEST = 400;




    public final static String RETURN_RESULT_MESSAGE_SUCCESS = "操作成功!";


    public final static String RETURN_RESULT_MESSAGE_SERVER_EXCEPTION = "服务异常!";


    public final static String RETURN_RESULT_MESSAGE_BAD_REQUEST = "数据错误!";

    public final static String RETURN_RESULT_MESSAGE_NO_THIS_USER = "当前登陆用户信息不存在，请于明日重试!";
    public final static String RETURN_RESULT_MESSAGE_NO_THIS_TASK = "未查找到当前任务！";
    public final static String RETURN_RESULT_MESSAGE_NO_FILE_SELECTED = "请选择需要上传到文件！";

}
