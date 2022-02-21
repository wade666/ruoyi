package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 仓库对象 t_warehouse
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
public class TWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 仓库名 */
    @Excel(name = "仓库名")
    private String warehouseName;

    /** 仓库管理员 */
    @Excel(name = "仓库管理员")
    private Long sysUserId;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 地址省市县以及详细地址暂时不区分，可能存在退货使用此地址 */
    @Excel(name = "地址省市县以及详细地址暂时不区分，可能存在退货使用此地址")
    private String address;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 是否默认 0是1否 */
    @Excel(name = "是否默认 0是1否")
    private Integer isDefault;

    /** 状态 0禁用 1正常 */
    @Excel(name = "状态 0禁用 1正常")
    private Integer state;

    /** 快递助手appKey */
    @Excel(name = "快递助手appKey")
    private String appKey;

    /** 快递助手appSecret */
    @Excel(name = "快递助手appSecret")
    private String appSecret;

    /** 版本号 */
    @Excel(name = "版本号")
    private Integer version;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWarehouseName(String warehouseName) 
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() 
    {
        return warehouseName;
    }
    public void setSysUserId(Long sysUserId) 
    {
        this.sysUserId = sysUserId;
    }

    public Long getSysUserId() 
    {
        return sysUserId;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }
    public void setIsDefault(Integer isDefault) 
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault() 
    {
        return isDefault;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setAppKey(String appKey) 
    {
        this.appKey = appKey;
    }

    public String getAppKey() 
    {
        return appKey;
    }
    public void setAppSecret(String appSecret) 
    {
        this.appSecret = appSecret;
    }

    public String getAppSecret() 
    {
        return appSecret;
    }
    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }

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
            .toString();
    }
}
