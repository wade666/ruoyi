package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品规格对象 t_specification
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
public class TSpecification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 可选项目 */
    @Excel(name = "可选项目")
    private String options;

    /** 绑定分类 */
    @Excel(name = "绑定分类")
    private Long productCategoryId;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 版本号 */
    private Integer version;

    /**
     * 是否删除，0是1否
     */
    private Integer isDel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setOptions(String options) 
    {
        this.options = options;
    }

    public String getOptions() 
    {
        return options;
    }
    public void setProductCategoryId(Long productCategoryId) 
    {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductCategoryId() 
    {
        return productCategoryId;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }
    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("options", getOptions())
            .append("productCategoryId", getProductCategoryId())
            .append("sort", getSort())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("isDel", getIsDel())
            .toString();
    }
}
