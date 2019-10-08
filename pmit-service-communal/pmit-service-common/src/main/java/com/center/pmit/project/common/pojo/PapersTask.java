package com.center.pmit.project.common.pojo;

import lombok.Data;

/**
 * 任务实体
 * @author blliul
 * @date 2019-09-04
 */
@Data
public class PapersTask {
    /**
     * 任务id
     */
    private Integer taskId;
    /**
     * 模版id
     */
    private Integer paperId;
    /**
     * 任务别名
     */
    private String paperAlias;
    /**
     * 任务下发的bd
     */
    private Integer bd;
    /**
     * 任务下发的bu
     */
    private Integer bu;
    /**
     * 任务下发的cu
     */
    private Integer cu;
    /**
     * 任务下发的地域
     */
    private Integer region;
    /**
     * 任务开始时间
     */
    private String startTime;
    /**
     * 任务结束时间
     */
    private String endTime;
    /**
     * 任务状态（待提交，审批中，待启动，运行中，已结束）
     */
    private Integer taskState;
    /**
     * 审批状态（null,1通过，2驳回）
     */
    private Integer approveState;
    /**
     * 驳回原因
     */
    private String approveRemark;
    /**
     * 审批人（工号）
     */
    private Integer approver;
    /**
     * 审批时间
     */
    private String approveTime;
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
     * 试卷模版
     */
    private Paper paper;

    /**
     * 任务提前提醒时间
     */
    private Integer remindTime;
    /**
     * 下发人形式1上传文件2bdbucu
     */
    private Integer deliveryType;
    /**
     * 需要自检员自检的人员数量
     */
    private int needCheckTypePersonCounts;
    /**
     * 前台约定参数
     */
    private int key;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 审批人
     */
    private String approverName;
    /**
     * 审批人域账号
     */
    private String approverAccount;
    /**
     * bdName
     */
    private String bdName;
    /**
     * buName
     */
    private String buName;

    /**
     * 界面完成率参数
     */
    private int totalPersons;
    private int finishPersons;
    private double score;


}
