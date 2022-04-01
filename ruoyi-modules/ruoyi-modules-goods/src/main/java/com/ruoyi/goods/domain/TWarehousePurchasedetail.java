package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购申请详情对象 t_warehouse_purchasedetail
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public class TWarehousePurchasedetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 采购申请id */
    @Excel(name = "采购申请id")
    private Long purchaseId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Integer applyNum;

    /** 采购单价,元 */
    @Excel(name = "采购单价,元")
    private BigDecimal applyPrice;

    /** 采购时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 预计到货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计到货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arriveTime;

    /** 待入库数量 */
    @Excel(name = "待入库数量")
    private Integer realNum;

    /** 已入库数量 */
    @Excel(name = "已入库数量")
    private Integer alreadyNum;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchCode;

    /** 版本号 */
    @Excel(name = "版本号")
    private Integer version;

    /** 删除标志（1代表存在 2代表删除） */
    private Integer delFlag;

    /** 商品名 */
    private String productName;

    /** 税率% */
    @Excel(name = "税率%")
    private BigDecimal taxRate;

    /** 含税单价(元) */
    @Excel(name = "含税单价(元)")
    private BigDecimal taxPrice;

    /** 含税金额(元) */
    @Excel(name = "含税金额(元)")
    private BigDecimal taxAmount;

    /** 采购金额(元) */
    @Excel(name = "采购金额(元)")
    private BigDecimal applyAmount;

    /** 商品规格 */
    @Excel(name = "商品规格")
    private String specificationValues;

    public String getSpecificationValues() {
        return specificationValues;
    }

    public void setSpecificationValues(String specificationValues) {
        this.specificationValues = specificationValues;
    }

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
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setApplyNum(Integer applyNum) 
    {
        this.applyNum = applyNum;
    }

    public Integer getApplyNum() 
    {
        return applyNum;
    }
    public void setApplyPrice(BigDecimal applyPrice) 
    {
        this.applyPrice = applyPrice;
    }

    public BigDecimal getApplyPrice() 
    {
        return applyPrice;
    }
    public void setApplyTime(Date applyTime) 
    {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() 
    {
        return applyTime;
    }
    public void setArriveTime(Date arriveTime) 
    {
        this.arriveTime = arriveTime;
    }

    public Date getArriveTime() 
    {
        return arriveTime;
    }
    public void setRealNum(Integer realNum) 
    {
        this.realNum = realNum;
    }

    public Integer getRealNum() 
    {
        return realNum;
    }
    public void setAlreadyNum(Integer alreadyNum) 
    {
        this.alreadyNum = alreadyNum;
    }

    public Integer getAlreadyNum() 
    {
        return alreadyNum;
    }
    public void setBatchCode(String batchCode)
    {
        this.batchCode = batchCode;
    }

    public String getBatchCode()
    {
        return batchCode;
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

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(BigDecimal taxPrice) {
        this.taxPrice = taxPrice;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseId", getPurchaseId())
            .append("productId", getProductId())
            .append("applyNum", getApplyNum())
            .append("applyPrice", getApplyPrice())
            .append("applyTime", getApplyTime())
            .append("arriveTime", getArriveTime())
            .append("realNum", getRealNum())
            .append("alreadyNum", getAlreadyNum())
            .append("batchCode", getBatchCode())
            .append("version", getVersion())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("taxRate", getTaxRate())
            .append("taxPrice", getTaxPrice())
            .append("taxAmount", getTaxAmount())
            .append("applyAmount", getApplyAmount())
            .append("specificationValues", getSpecificationValues())
            .toString();
    }
}
