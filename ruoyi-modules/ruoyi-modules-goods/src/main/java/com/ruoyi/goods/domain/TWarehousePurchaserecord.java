package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购申请审核记录对象 t_warehouse_purchaserecord
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public class TWarehousePurchaserecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 采购申请id */
    @Excel(name = "采购申请id")
    private Long purchaseId;

    /** 审核类型 1采购审核 2入库审核 */
    @Excel(name = "审核类型 1采购审核 2入库审核")
    private Integer checkType;

    /** 审核详情 */
    @Excel(name = "审核详情")
    private String checkOper;

    /** 审核人id */
    @Excel(name = "审核人id")
    private Long sysUserId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPurchaseId(Long purchaseId) 
    {
        this.purchaseId = purchaseId;
    }

    public Long getPurchaseId() 
    {
        return purchaseId;
    }
    public void setCheckOper(String checkOper) 
    {
        this.checkOper = checkOper;
    }

    public String getCheckOper() 
    {
        return checkOper;
    }
    public void setSysUserId(Long sysUserId) 
    {
        this.sysUserId = sysUserId;
    }

    public Long getSysUserId() 
    {
        return sysUserId;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseId", getPurchaseId())
            .append("checkOper", getCheckOper())
            .append("checkType", getCheckType())
            .append("sysUserId", getSysUserId())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
