package com.center.pmit.project.common.exception;

/**
 * 自定义用户不存在异常
 *
 * @author Administrator
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    private int code;

    private String msg;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
