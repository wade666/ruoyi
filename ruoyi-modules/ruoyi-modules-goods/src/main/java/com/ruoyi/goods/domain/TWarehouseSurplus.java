package com.ruoyi.goods.domain;

import lombok.Data;
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
@Data
public class TWarehouseSurplus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存id */
    private Long surplusId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 商品sku */
    @Excel(name = "商品sku")
    private String sn;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchCode;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("surplusId", getSurplusId())
            .append("productId", getProductId())
            .append("sn", getSn())
            .append("batchCode", getBatchCode())
            .append("warehouseId", getWarehouseId())
            .append("surplusNum", getSurplusNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
