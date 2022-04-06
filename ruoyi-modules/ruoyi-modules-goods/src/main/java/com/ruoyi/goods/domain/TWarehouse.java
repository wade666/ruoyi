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
 * 仓库对象 t_warehouse
 *
 * @author ruoyi
 * @date 2022-03-08
 */
@ApiModel(value = "仓库对象")
@Data
public class TWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 仓库名 */
    @ApiModelProperty(value = "仓库名",required = true)
    @Excel(name = "仓库名")
    private String warehouseName;

    /** 仓库管理员 */
    @ApiModelProperty(value = "仓库管理员",required = true)
    @Excel(name = "仓库管理员")
    private Long sysUserId;

    /** 联系人 */
    @ApiModelProperty(value = "联系人")
    @Excel(name = "联系人")
    private String contact;

    /** 地址省市县以及详细地址暂时不区分，可能存在退货使用此地址 */
    @ApiModelProperty(value = "地址")
    @Excel(name = "地址省市县以及详细地址暂时不区分，可能存在退货使用此地址")
    private String address;

    /** 手机 */
    @ApiModelProperty(value = "手机")
    @Excel(name = "手机")
    private String phone;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    @Excel(name = "备注")
    private String memo;

    /** 是否默认 0是1否 */
    @ApiModelProperty(value = "是否默认 0是1否",allowableValues = "0,1")
    @Excel(name = "是否默认 0是1否")
    private Integer isDefault;

    /** 状态 0禁用 1正常 */
    @ApiModelProperty(value = "状态 0禁用 1正常",allowableValues = "0,1")
    @Excel(name = "状态 0禁用 1正常")
    private Integer state;

    /** 快递助手appKey */
    @Excel(name = "快递助手appKey")
    private String appKey;

    /** 快递助手appSecret */
    @Excel(name = "快递助手appSecret")
    private String appSecret;

    /** 面积（平方米） */
    @ApiModelProperty(value = "面积（平方米）")
    @Excel(name = "面积", readConverterExp = "平=方米")
    private BigDecimal space;

    /** 仓库所属公司id */
    @ApiModelProperty(value = "仓库所属公司id",required = true)
    @Excel(name = "仓库所属公司id")
    private Long companyId;

    /** 仓库类型（1真实，2虚拟） */
    @ApiModelProperty(value = "仓库类型（1真实，2虚拟）")
    @Excel(name = "仓库类型", readConverterExp = "1=真实，2虚拟")
    private Integer warehouseType;

    /** 仓库父id */
    @ApiModelProperty(value = "仓库父id")
    private Long parentId;

    /** 仓库所属公司名 */
    private String companyName;
    /** 是否默认*/
    private String isDefaultName;
    /** 状态*/
    private String stateName;
    /** 用户昵称*/
    private String nickName;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("warehouseName", getWarehouseName())
                .append("sysUserId", getSysUserId())
                .append("contact", getContact())
                .append("address", getAddress())
                .append("phone", getPhone())
                .append("memo", getMemo())
                .append("isDefault", getIsDefault())
                .append("state", getState())
                .append("appKey", getAppKey())
                .append("appSecret", getAppSecret())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("version", getVersion())
                .append("space", getSpace())
                .append("companyId", getCompanyId())
                .append("warehouseType", getWarehouseType())
                .append("parentId", getParentId())
                .toString();
    }
}
