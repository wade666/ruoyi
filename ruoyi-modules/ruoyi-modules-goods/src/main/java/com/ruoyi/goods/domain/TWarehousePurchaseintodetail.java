package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购入库单详情对象 t_warehouse_purchaseintodetail
 * 
 * @author ruoyi
 * @date 2022-03-24
 */
public class TWarehousePurchaseintodetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 采购入库单id */
    @Excel(name = "采购入库单id")
    private Long purchaseintoId;

    /** 采购申请id */
    @Excel(name = "采购申请id")
    private Long purchaseId;

    /** 实到数量 */
    @Excel(name = "实到数量")
    private Integer arriveNum;

    /** 采购单价(元) */
    @Excel(name = "采购单价(元)")
    private BigDecimal applyPrice;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchCode;

    /** 税率% */
    @Excel(name = "税率%")
    private BigDecimal taxRate;

    /** 含税单价(元) */
    @Excel(name = "含税单价(元)")
    private BigDecimal taxPrice;

    /** 含税金额(元) */
    @Excel(name = "含税金额(元)")
    private BigDecimal taxAmount;

    /** 采购总金额(元) */
    @Excel(name = "采购总金额(元)")
    private BigDecimal applyAmount;

    /** 商品规格 */
    @Excel(name = "商品规格")
    private String specificationValues;

    /** 版本号 */
    @Excel(name = "版本号")
    private Integer version;

    /** 删除标志（1代表存在 2代表删除） */
    private Integer delFlag;
    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 采购详情id */
    @Excel(name = "采购详情id")
    private Long purchaseDetailId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPurchaseDetailId() {
        return purchaseDetailId;
    }

    public void setPurchaseDetailId(Long purchaseDetailId) {
        this.purchaseDetailId = purchaseDetailId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPurchaseintoId(Long purchaseintoId) 
    {
        this.purchaseintoId = purchaseintoId;
    }

    public Long getPurchaseintoId() 
    {
        return purchaseintoId;
    }
    public void setPurchaseId(Long purchaseId) 
    {
        this.purchaseId = purchaseId;
    }

    public Long getPurchaseId() 
    {
        return purchaseId;
    }
    public void setArriveNum(Integer arriveNum) 
    {
        this.arriveNum = arriveNum;
    }

    public Integer getArriveNum() 
    {
        return arriveNum;
    }
    public void setApplyPrice(BigDecimal applyPrice) 
    {
        this.applyPrice = applyPrice;
    }

    public BigDecimal getApplyPrice() 
    {
        return applyPrice;
    }
    public void setBatchCode(String batchCode)
    {
        this.batchCode = batchCode;
    }

    public String getBatchCode()
    {
        return batchCode;
    }
    public void setTaxRate(BigDecimal taxRate) 
    {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() 
    {
        return taxRate;
    }
    public void setTaxPrice(BigDecimal taxPrice) 
    {
        this.taxPrice = taxPrice;
    }

    public BigDecimal getTaxPrice() 
    {
        return taxPrice;
    }
    public void setTaxAmount(BigDecimal taxAmount) 
    {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTaxAmount() 
    {
        return taxAmount;
    }
    public void setApplyAmount(BigDecimal applyAmount) 
    {
        this.applyAmount = applyAmount;
    }

    public BigDecimal getApplyAmount() 
    {
        return applyAmount;
    }
    public void setSpecificationValues(String specificationValues) 
    {
        this.specificationValues = specificationValues;
    }

    public String getSpecificationValues() 
    {
        return specificationValues;
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
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseintoId", getPurchaseintoId())
            .append("purchaseId", getPurchaseId())
            .append("arriveNum", getArriveNum())
            .append("applyPrice", getApplyPrice())
            .append("batchCode", getBatchCode())
            .append("taxRate", getTaxRate())
            .append("taxPrice", getTaxPrice())
            .append("taxAmount", getTaxAmount())
            .append("applyAmount", getApplyAmount())
            .append("specificationValues", getSpecificationValues())
            .append("version", getVersion())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
