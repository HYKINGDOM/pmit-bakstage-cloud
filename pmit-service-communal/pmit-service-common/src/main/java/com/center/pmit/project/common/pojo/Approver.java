package com.center.pmit.project.common.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 审批人表
 * @author blliul
 * @date 2019-09-04
 */
@Data
public class Approver implements Serializable {
    private static final long serialVersionUID = -7755162995496909497L;
    private Integer seqId;
    /**
     * 审批人工号
     */
    private Integer approverNum;
    /**
     * 审批人bd
     */

    private Integer bd;
    private String bu;
    private String region;
    /**
     * 审批人领域
     */
    private String field;
}