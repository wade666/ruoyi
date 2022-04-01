package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 出入库明细对象 t_warehouse_surplusdetails
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
@Data
public class TWarehouseSurplusdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 商品编码id */
    @Excel(name = "商品编码id")
    private String sn;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 厂家编码 */
    @Excel(name = "厂家编码")
    private Long supplierId;

    /** 出入库类型（1入库，2出库） */
    @Excel(name = "出入库类型", readConverterExp = "1=入库，2出库")
    private Integer surplusType;

    /** 出入库详情（1生产入库 2调拨入库 3售后入库 4其他入库 5采购入库，6销售出库 7调拨出库 8其他出库） */
    @Excel(name = "出入库详情", readConverterExp = "1=生产入库,2=调拨入库,3=售后入库,4=其他入库,5=采购入库，6销售出库,7=调拨出库,8=其他出库")
    private Integer detailType;

    /** 备注 */
    @Excel(name = "备注")
    private String bak;

    /**出入库类型（1入库，2出库） */
    private String surplusTypeName;
    /** 出入库详情*/
    private String detailTypeName;

    /** 采购入库单详情id */
    @Excel(name = "采购入库单详情id")
    private Long purchaseintodetailId;

    /** 数量 */
    @Excel(name = "数量")
    private Integer arriveNum;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchCode;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("sn", getSn())
            .append("warehouseId", getWarehouseId())
            .append("price", getPrice())
            .append("supplierId", getSupplierId())
            .append("createTime", getCreateTime())
            .append("surplusType", getSurplusType())
            .append("detailType", getDetailType())
            .append("bak", getBak())
            .toString();
    }
}
