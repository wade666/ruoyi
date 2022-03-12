package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品标签对象 t_product_label
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
public class TProductLabel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String labelName;

    /** 备注 */
    @Excel(name = "备注")
    private String bak;

    /** 是否删除 0是1否 */
    private Integer isDel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLabelName(String labelName) 
    {
        this.labelName = labelName;
    }

    public String getLabelName() 
    {
        return labelName;
    }
    public void setBak(String bak) 
    {
        this.bak = bak;
    }

    public String getBak() 
    {
        return bak;
    }
    public void setIsDel(Integer isDel) 
    {
        this.isDel = isDel;
    }

    public Integer getIsDel() 
    {
        return isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("labelName", getLabelName())
            .append("bak", getBak())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDel", getIsDel())
            .append("version", getVersion())
            .toString();
    }
}
