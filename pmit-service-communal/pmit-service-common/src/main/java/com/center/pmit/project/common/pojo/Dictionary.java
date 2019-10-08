package com.center.pmit.project.common.pojo;

import lombok.Data;

/**
 * 字典实体
 * @author blliul
 * @date 2019-09-04
 */
@Data
public class Dictionary {
    private Integer seqId;
    private Integer parentId;
    private String dicName;
    private Integer dicValue;
    private Integer sort;
    private String dicType;
    private String createTime;
    private Integer createBy;
    private String updateTime;
    private Integer updateBy;
}
