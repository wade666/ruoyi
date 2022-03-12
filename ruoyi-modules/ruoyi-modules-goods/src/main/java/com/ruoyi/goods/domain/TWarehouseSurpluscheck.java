package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 库存盘点对象 t_warehouse_surpluscheck
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
public class TWarehouseSurpluscheck extends BaseEntity
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

    /** 盘点数量 */
    @Excel(name = "盘点数量")
    private Integer surplusNum;

    /** 备注 */
    @Excel(name = "备注")
    private String bak;

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
    public void setSurplusNum(Integer surplusNum) 
    {
        this.surplusNum = surplusNum;
    }

    public Integer getSurplusNum() 
    {
        return surplusNum;
    }
    public void setBak(String bak) 
    {
        this.bak = bak;
    }

    public String getBak() 
    {
        return bak;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("warehouseId", getWarehouseId())
            .append("surplusNum", getSurplusNum())
            .append("createTime", getCreateTime())
            .append("bak", getBak())
            .toString();
    }
}
