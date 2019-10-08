package com.center.pmit.project.common.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @author blliul
 * @date 2019-08-16
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -7755162995496909499L;
    private Integer empNo;
    private String empName;
    private String domainName;
    private String phone;
    private String idCard;
    private String hrCuNo;
    private String hrCuName;
    private String hrBuNo;
    private String hrBuName;
    private String hrBdNo;
    private String hrBdName;
    private String hrBgno;
    private String hrBgName;
    private String status;
    private String comeDate;
    private String positionName;
    private String workCityName;
    private String hwDomain;
    private Integer isNewEmp;
    private String updateTime;
    private Inspector inspector;
    private Approver approver;
    private Operator operator;
}
