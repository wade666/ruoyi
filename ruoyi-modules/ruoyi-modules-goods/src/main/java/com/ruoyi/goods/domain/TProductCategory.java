package com.ruoyi.goods.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类对象 t_product_category
 *
 * @author ruoyi
 * @date 2022-01-24
 */
@Data
@ApiModel(value = "商品分类对象")
public class TProductCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    /**
     * 父分类id
     */
    @ApiModelProperty(value = "父分类id")
    @Excel(name = "父分类id")
    private Long parentId;

    /**
     * 祖级列表
     */
    @ApiModelProperty(value = "祖级列表")
    @Excel(name = "祖级列表")
    private String ancestors;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    @Excel(name = "分类名称")
    private String categoryName;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;

    /**
     * 分类状态（0正常 1停用）
     */
    @ApiModelProperty(value = "分类状态0正常 1停用）",allowableValues = "0,1")
    @Excel(name = "分类状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
    /**
     * 子分类
     */
    @ApiModelProperty(value = "子分类")
    private List<TProductCategory> children = new ArrayList<TProductCategory>();

}
