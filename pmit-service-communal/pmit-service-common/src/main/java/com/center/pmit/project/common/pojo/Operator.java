package com.center.pmit.project.common.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 操作权限人员
 * @author blliul
 * @date 2019-09-04
 */
@Data
public class Operator implements Serializable {
    private static final long serialVersionUID = -7755162995496909496L;
    private Integer seqId;
    private Integer isstNum;
}
