package com.ruoyi.goods.domain.vo;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ruoyi.goods.domain.TProductBrand;
import com.ruoyi.goods.domain.TProductCategory;

/**
 * Treeselect树结构实体类
 * 
 * @author ruoyi
 */
public class TreeSelect implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect> children;

    public TreeSelect()
    {

    }
    public TreeSelect(TProductBrand tProductBrand)
    {
        this.id = tProductBrand.getBrandId();
        this.label = tProductBrand.getBrandName();
        this.children = tProductBrand.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }
    public TreeSelect(TProductCategory tProductCategory)
    {
        this.id = tProductCategory.getCategoryId();
        this.label = tProductCategory.getCategoryName();
        this.children = tProductCategory.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public List<TreeSelect> getChildren()
    {
        return children;
    }

    public void setChildren(List<TreeSelect> children)
    {
        this.children = children;
    }
}
