package com.center.pmit.project.common.pojo;

import lombok.Data;

/**
 * 缺考人实体
 * @author blliul
 * @date 2019-09-04
 */
@Data
public class TaskAbsence {
    private Integer seqId;
    /**
     * 任务id
     */
    private Integer taskId;
    /**
     * 需要考试的人员（工号用逗号隔开，excel上传）
     */
    private String needExamPersons;
    /**
     * 已经考过的人员
     */
    private String finishExamPersons;
}