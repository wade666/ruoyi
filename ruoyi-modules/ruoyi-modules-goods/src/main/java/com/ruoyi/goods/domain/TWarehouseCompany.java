package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 仓库所属公司对象 t_warehouse_company
 * 
 * @author ruoyi
 * @date 2022-03-07
 */
public class TWarehouseCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库所属公司id */
    private Long companyId;

    /** 仓库所属公司名 */
    @Excel(name = "仓库所属公司名")
    private String companyName;

    /** 公司类型，1分销商，2供应商，3客户 */
    @Excel(name = "公司类型，1分销商，2供应商，3客户")
    private Integer companyType;

    /** 备注 */
    @Excel(name = "备注")
    private String bak;

    /** 公司类型*/
    private String companyTypeName;

    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyType(Integer companyType) 
    {
        this.companyType = companyType;
    }

    public Integer getCompanyType() 
    {
        return companyType;
    }
    public void setBak(String bak) 
    {
        this.bak = bak;
    }

    public String getBak() 
    {
        return bak;
    }

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("companyType", getCompanyType())
            .append("bak", getBak())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
