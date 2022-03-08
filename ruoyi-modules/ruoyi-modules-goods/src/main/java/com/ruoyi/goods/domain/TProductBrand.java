package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品品牌对象 t_product_brand
 *
 * @author ruoyi
 * @date 2022-01-27
 */
public class TProductBrand extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 父分类id
     */
    @Excel(name = "父分类id")
    private Long parentId;

    /**
     * 祖级列表
     */
    @Excel(name = "祖级列表")
    private String ancestors;

    /**
     * 品牌名称
     */
    @Excel(name = "品牌名称")
    private String brandName;

    /**
     * 显示顺序
     */
    private Integer sortNum;

    /**
     * 品牌状态（0正常 1停用）
     */
    @Excel(name = "品牌状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
    /** logo */
    @Excel(name = "logo")
    private String logo;

    /** 介绍 */
    @Excel(name = "介绍")
    private String introduction;
    /**
     * 子分类
     */
    private List<TProductBrand> children = new ArrayList<TProductBrand>();

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public List<TProductBrand> getChildren() {
        return children;
    }

    public void setChildren(List<TProductBrand> children) {
        this.children = children;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("brandId", getBrandId())
                .append("parentId", getParentId())
                .append("ancestors", getAncestors())
                .append("brandName", getBrandName())
                .append("sortNum", getSortNum())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("logo", getLogo())
                .append("introduction", getIntroduction())
                .toString();
    }
}
