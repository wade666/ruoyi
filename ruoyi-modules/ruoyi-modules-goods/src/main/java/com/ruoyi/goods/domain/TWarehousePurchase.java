package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购申请对象 t_warehouse_purchase
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
public class TWarehousePurchase extends BaseEntity
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

    /** 采购人id */
    @Excel(name = "采购人id")
    private Long sysUserId;

    /** 当前审核人id */
    private Long nowCheckId;

    /** 审核人流程 */
    @Excel(name = "审核人流程")
    private String checkStep;

    /** 审核人ids */
    private String checkIds;

    /** 当前审核人数组下标 */
    private Integer checkIndex;

    /** 版本号 */
    private Integer version;

    /** 查询类型 1查本人 2查仓库 */
    private Integer queryType;

    /** 审核人账户 */
    private String userName;

    /** 删除标志（1代表存在 2代表删除） */
    private Integer delFlag;

    /** 预付款,元 */
    @Excel(name = "预付款,元")
    private BigDecimal deposit;

    /** 采购详情 */
    private List<TWarehousePurchasedetail> detailList;

    public List<TWarehousePurchasedetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TWarehousePurchasedetail> detailList) {
        this.detailList = detailList;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Integer getDelFlag() {
        return delFlag;
    }
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCheckIds() {
        return checkIds;
    }

    public void setCheckIds(String checkIds) {
        this.checkIds = checkIds;
    }

    public Integer getCheckIndex() {
        return checkIndex;
    }

    public void setCheckIndex(Integer checkIndex) {
        this.checkIndex = checkIndex;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public Long getWarehouseId()
    {
        return warehouseId;
    }
    public void setSupplierId(Long supplierId)
    {
        this.supplierId = supplierId;
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
    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Integer getVersion()
    {
        return version;
    }

    public String getApplyStateName() {
        return applyStateName;
    }

    public void setApplyStateName(String applyStateName) {
        this.applyStateName = applyStateName;
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

    public Long getNowCheckId() {
        return nowCheckId;
    }

    public void setNowCheckId(Long nowCheckId) {
        this.nowCheckId = nowCheckId;
    }

    public String getCheckStep() {
        return checkStep;
    }

    public void setCheckStep(String checkStep) {
        this.checkStep = checkStep;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("warehouseId", getWarehouseId())
                .append("applyState", getApplyState())
                .append("sysUserId", getSysUserId())
                .append("createBy", getCreateBy())
                .append("nowCheckId", getNowCheckId())
                .append("checkStep", getCheckStep())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("version", getVersion())
                .append("remark", getRemark())
                .toString();
    }
}
