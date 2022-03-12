package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 库存对象 t_warehouse_surplus
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
public class TWarehouseSurplus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存id */
    private Long surplusId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 商品编码id */
    @Excel(name = "商品编码id")
    private Long productCode;

    /** 批次编码id */
    @Excel(name = "批次编码id")
    private Long batchCode;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;

    /** 库存数 */
    @Excel(name = "库存数")
    private Integer surplusNum;

    /** 库存预警值 */
    private Integer warnNum;
    /** 是否预警 */
    private Boolean warn=false;

    public void setSurplusId(Long surplusId) 
    {
        this.surplusId = surplusId;
    }

    public Long getSurplusId() 
    {
        return surplusId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductCode(Long productCode) 
    {
        this.productCode = productCode;
    }

    public Long getProductCode() 
    {
        return productCode;
    }
    public void setBatchCode(Long batchCode) 
    {
        this.batchCode = batchCode;
    }

    public Long getBatchCode() 
    {
        return batchCode;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setSurplusNum(Integer surplusNum) 
    {
        this.surplusNum = surplusNum;
    }

    public Integer getSurplusNum() 
    {
        return surplusNum;
    }
    public Integer getWarnNum() {
        return warnNum;
    }

    public void setWarnNum(Integer warnNum) {
        this.warnNum = warnNum;
    }

    public Boolean getWarn() {
        return warn;
    }

    public void setWarn(Boolean warn) {
        this.warn = warn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("surplusId", getSurplusId())
            .append("productId", getProductId())
            .append("productCode", getProductCode())
            .append("batchCode", getBatchCode())
            .append("warehouseId", getWarehouseId())
            .append("surplusNum", getSurplusNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
