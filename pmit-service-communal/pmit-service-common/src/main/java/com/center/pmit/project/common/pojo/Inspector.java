package com.center.pmit.project.common.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @author blliul
 * @date 2019-09-04
 * 自检员实体
 */
@Data
public class Inspector implements Serializable {
    private static final long serialVersionUID = -7755162995496909498L;
    /**
     * id
     */
    private Integer seqId;
    /**
     * 自检员工号
     */
    private Integer isstNum;
    /**
     * 自检员bd
     */
    private Integer bd;
    /**
     * 自检员bu
     */
    private String bu;
    /**
     * 自检员的cu
     */
    private String cu;
    /**
     * 自检员的地域
     */
    private Integer region;
    /**
     * 领域（自检员领域默认为人资1）
     */
    private Integer field;
    /**
     * 自检类型（1招聘面试自检，2入职入入项自检，3季度自检，4调配出项自检，5离职释放自检，6月度自检）
     */
    private String checkType;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建人
     */
    private Integer createBy;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 修改人
     */
    private Integer updateBy;
    /**
     * 当前需要查找的自检类型
     */
    private int currentCheckType;
    /**
     * 当前自检员需要查询结果的列
     */
    private String taskColumn;
    /**
     * 需要考试的人员
     */
    private String needTestPersons;
}
