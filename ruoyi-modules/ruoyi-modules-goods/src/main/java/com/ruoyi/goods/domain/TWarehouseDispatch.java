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
 * 调拨单对象 t_warehouse_dispatch
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
@Data
@ApiModel(value = "调拨单对象")
public class TWarehouseDispatch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 调拨单号 */
    @Excel(name = "调拨单号")
    private Long dispatchNo;

    /** 发货仓库id */
    @ApiModelProperty(value = "发货仓库id",required = true)
    @Excel(name = "发货仓库id")
    private Long fromWarehouseId;
    private String fromWarehouseName;

    /** 收货仓库id */
    @ApiModelProperty(value = "收货仓库id",required = true)
    @Excel(name = "收货仓库id")
    private Long toWarehouseId;
    private String toWarehouseName;

    /** 调拨类型 1实际调拨 2虚拟调拨 */
    @ApiModelProperty(value = "调拨类型 1实际调拨 2虚拟调拨", required = true, allowableValues = "1,2")
    @Excel(name = "调拨类型 1实际调拨 2虚拟调拨")
    private Integer dispatchType;
    private String dispatchTypeName;

    /** 调拨状态 1待处理 2处理中 3已完成 */
    @Excel(name = "调拨状态 1待处理 2处理中 3已完成")
    private Integer dispatchState;
    private String dispatchStateName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 删除标志（1代表存在 2代表删除） */
    private Integer delFlag;

    /** 调拨单详情 */
    @ApiModelProperty(value = "调拨单详情",required = true)
    private List<TWarehouseDispatchdetail> detailList;

    /** 调拨类型 1调拨入库 2调拨出库 */
    @ApiModelProperty(value = "调拨类型",allowableValues = "1,2")
    private Integer intoType;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dispatchNo", getDispatchNo())
            .append("fromWarehouseId", getFromWarehouseId())
            .append("toWarehouseId", getToWarehouseId())
            .append("dispatchType", getDispatchType())
            .append("dispatchState", getDispatchState())
            .append("createUserId", getCreateUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
