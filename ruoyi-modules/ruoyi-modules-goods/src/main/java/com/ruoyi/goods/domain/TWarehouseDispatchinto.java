package com.ruoyi.goods.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 调拨出入库单对象 t_warehouse_dispatchinto
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
@ApiModel(value = "调拨出入库单对象")
@Data
public class TWarehouseDispatchinto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 出入库单号 */
    @Excel(name = "出入库单号")
    private Long dispatchintoNo;

    /** 关联调拨单号 */
    @ApiModelProperty(value = "关联调拨单号",required = true)
    @Excel(name = "关联调拨单号")
    private Long dispatchNo;

    /** 仓库id */
    @ApiModelProperty(value = "仓库id",required = true)
    @Excel(name = "仓库id")
    private Long warehouseId;
    private String warehouseName;

    /** 调拨类型 1调拨入库 2调拨出库 */
    @ApiModelProperty(value = "调拨类型 1调拨入库 2调拨出库", required = true, allowableValues = "1,2")
    @Excel(name = "调拨类型 1调拨入库 2调拨出库")
    private Integer intoType;
    private String intoTypeName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 删除标志（1代表存在 2代表删除） */
    private Integer delFlag;

    /** 调拨单详情 */
    @ApiModelProperty(value = "调拨单详情",required = true)
    private List<TWarehouseDispatchdetail> detailList;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dispatchintoNo", getDispatchintoNo())
            .append("dispatchNo", getDispatchNo())
            .append("warehouseId", getWarehouseId())
            .append("intoType", getIntoType())
            .append("createUserId", getCreateUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
