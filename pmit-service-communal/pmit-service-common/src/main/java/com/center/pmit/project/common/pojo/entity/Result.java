package com.center.pmit.project.common.pojo.entity;

import lombok.Data;

/**
 * 〈响应实体〉
 *
 * @author yihur
 */
@Data
public class Result {

    private int code;
    private String message;
    private Object data;

}
