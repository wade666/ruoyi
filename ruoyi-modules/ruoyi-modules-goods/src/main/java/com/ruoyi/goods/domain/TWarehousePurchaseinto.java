package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购入库单对象 t_warehouse_purchaseinto
 * 
 * @author ruoyi
 * @date 2022-03-24
 */
public class TWarehousePurchaseinto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;
    private String warehouseName;

    /** 供货商id */
    @Excel(name = "供货商id")
    private Long supplierId;
    private String supplierName;

    /** 审核状态（0待提交 1审核中 2审核通过 3审核拒绝） */
    @Excel(name = "审核状态", readConverterExp = "0=待提交,1=审核中,2=审核通过,3=审核拒绝")
    private Integer applyState;
    private String applyStateName;

    /** 采购入库人id */
    @Excel(name = "采购入库人id")
    private Long sysUserId;

    /** 当前审核人id */
    @Excel(name = "当前审核人id")
    private Long nowCheckId;

    /** 审核人流程 */
    @Excel(name = "审核人流程")
    private String checkStep;

    /** 审核人ids */
    @Excel(name = "审核人ids")
    private String checkIds;

    /** 当前审核人数组下标 */
    private Integer checkIndex;

    /** 付款金额(元) */
    @Excel(name = "付款金额(元)")
    private BigDecimal payMoney;

    /** 版本号 */
    private Integer version;

    /** 删除标志（1代表存在 2代表删除） */
    private Integer delFlag;

    /** 采购申请id */
    private Long purchaseId;

    /** 查询类型 1查本人 2查仓库 */
    private Integer queryType;

    /** 采购入库单详情 */
    private List<TWarehousePurchaseintodetail> detailList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setApplyState(Integer applyState) 
    {
        this.applyState = applyState;
    }

    public Integer getApplyState() 
    {
        return applyState;
    }
    public void setSysUserId(Long sysUserId) 
    {
        this.sysUserId = sysUserId;
    }

    public Long getSysUserId() 
    {
        return sysUserId;
    }
    public void setNowCheckId(Long nowCheckId) 
    {
        this.nowCheckId = nowCheckId;
    }

    public Long getNowCheckId() 
    {
        return nowCheckId;
    }
    public void setCheckStep(String checkStep) 
    {
        this.checkStep = checkStep;
    }

    public String getCheckStep() 
    {
        return checkStep;
    }
    public void setCheckIds(String checkIds) 
    {
        this.checkIds = checkIds;
    }

    public String getCheckIds() 
    {
        return checkIds;
    }
    public void setCheckIndex(Integer checkIndex) 
    {
        this.checkIndex = checkIndex;
    }

    public Integer getCheckIndex() 
    {
        return checkIndex;
    }
    public void setPayMoney(BigDecimal payMoney) 
    {
        this.payMoney = payMoney;
    }

    public BigDecimal getPayMoney() 
    {
        return payMoney;
    }
    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    @Override
    public String getWarehouseName() {
        return warehouseName;
    }

    @Override
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getApplyStateName() {
        return applyStateName;
    }

    public void setApplyStateName(String applyStateName) {
        this.applyStateName = applyStateName;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<TWarehousePurchaseintodetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TWarehousePurchaseintodetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseId", getWarehouseId())
            .append("supplierId", getSupplierId())
            .append("applyState", getApplyState())
            .append("sysUserId", getSysUserId())
            .append("nowCheckId", getNowCheckId())
            .append("checkStep", getCheckStep())
            .append("checkIds", getCheckIds())
            .append("checkIndex", getCheckIndex())
            .append("payMoney", getPayMoney())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
