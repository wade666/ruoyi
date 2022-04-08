package com.ruoyi.goods.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 库存对象 t_warehouse_surplus
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
@ApiModel(value = "库存对象")
@Data
public class TWarehouseSurplus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存id */
    private Long surplusId;

    /** 商品id */
    @ApiModelProperty(value = "商品id",required = true)
    @Excel(name = "商品id")
    private Long productId;

    /** 商品sku */
    @ApiModelProperty(value = "商品sku")
    @Excel(name = "商品sku")
    private String sn;

    /** 批次号 */
    @ApiModelProperty(value = "批次号",required = true)
    @Excel(name = "批次号")
    private String batchCode;

    /** 仓库id */
    @ApiModelProperty(value = "仓库id",required = true)
    @Excel(name = "仓库id")
    private Long warehouseId;

    /** 库存数 */
    @ApiModelProperty(value = "库存数")
    @Excel(name = "库存数")
    private Integer surplusNum;

    /** 库存预警值 */
    @ApiModelProperty(value = "库存预警值")
    private Integer warnNum;
    /** 是否预警 */
    @ApiModelProperty(value = "是否预警")
    private Boolean warn=false;

    /** 商品名称 */
    @ApiModelProperty(value = "商品名称")
    private String productName;

    /** 规格值[] */
    @ApiModelProperty(value = "规格值[]")
    private String specificationValues;

    /** 销售价 */
    @ApiModelProperty(value = "销售价")
    private BigDecimal price;

    /** 分类id */
    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    /** 商品规格图片 */
    @ApiModelProperty(value = "商品规格图片")
    private String image;

    /** 成本价 */
    @ApiModelProperty(value = "成本价")
    private BigDecimal cost;

    /** 重量 */
    @ApiModelProperty(value = "重量(kg)")
    private BigDecimal weight;

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
