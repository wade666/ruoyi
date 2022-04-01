package com.ruoyi.goods.domain;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 调拨单详情对象 t_warehouse_dispatchdetail
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
@Data
@ApiModel(value = "调拨单详情对象")
public class TWarehouseDispatchdetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 调拨单号 */
    @Excel(name = "调拨单号")
    private Long dispatchNo;

    /** 批次号 */
    @Excel(name = "批次号")
    @ApiModelProperty(value = "批次号",required = true)
    private String batchCode;

    /** 商品sku，唯一 */
    @Excel(name = "商品sku，唯一")
    @ApiModelProperty(value = "商品sku")
    private String sn;

    /** 商品名称 */
    @Excel(name = "商品名称")
    @ApiModelProperty(value = "商品名称",required = true)
    private String productName;

    /** 规格值[] */
    @Excel(name = "规格值[]")
    @ApiModelProperty(value = "规格值[]",required = true)
    private String specificationValues;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty(value = "单位")
    private String unit;

    /** 数量 */
    @Excel(name = "数量")
    @ApiModelProperty(value = "数量")
    private Integer num;

    /** 单价 */
    @Excel(name = "单价")
    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    /** 总价 */
    @Excel(name = "总价")
    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dispatchNo", getDispatchNo())
            .append("batchCode", getBatchCode())
            .append("sn", getSn())
            .append("productName", getProductName())
            .append("specificationValues", getSpecificationValues())
            .append("unit", getUnit())
            .append("num", getNum())
            .append("unitPrice", getUnitPrice())
            .append("totalPrice", getTotalPrice())
            .append("remark", getRemark())
            .toString();
    }
}
