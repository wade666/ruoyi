package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 库存预警设置对象 t_warehouse_surpluswarn
 * 
 * @author ruoyi
 * @date 2022-03-09
 */
public class TWarehouseSurpluswarn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;

    /** 预警值 */
    @Excel(name = "预警值")
    private Integer warnNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setWarnNum(Integer warnNum) 
    {
        this.warnNum = warnNum;
    }

    public Integer getWarnNum()
    {
        return warnNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("warehouseId", getWarehouseId())
            .append("warnNum", getWarnNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
