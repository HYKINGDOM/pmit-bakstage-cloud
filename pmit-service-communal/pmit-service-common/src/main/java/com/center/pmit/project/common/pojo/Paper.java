package com.center.pmit.project.common.pojo;

import lombok.Data;

/**
 * @author blliul
 * @date 2019-09-05
 */
@Data
public class Paper {
    private Integer paperId;
    private Integer paperField;
    private Integer paperType;
    private Integer checkType;
    private String paperTitle;
    private Object paperContent;
    private String createTime;
    private Integer createBy;
    private String createName;
    private String updateTime;
    private Integer updateBy;
    private Integer key;

}
