package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品规格换算对象 t_product_conversion_proportion
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
public class TProductConversionProportion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long conversionId;

    /** 换算率 */
    @Excel(name = "换算率")
    private Long conversionProportion;

    /** 规格 */
    @Excel(name = "规格")
    private String specificationValues;

    /** 是否删除 0是1否 */
    @Excel(name = "是否删除 0是1否")
    private Integer isDel;

    public void setConversionId(Long conversionId) 
    {
        this.conversionId = conversionId;
    }

    public Long getConversionId() 
    {
        return conversionId;
    }
    public void setConversionProportion(Long conversionProportion) 
    {
        this.conversionProportion = conversionProportion;
    }

    public Long getConversionProportion() 
    {
        return conversionProportion;
    }
    public void setSpecificationValues(String specificationValues) 
    {
        this.specificationValues = specificationValues;
    }

    public String getSpecificationValues() 
    {
        return specificationValues;
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
            .append("conversionId", getConversionId())
            .append("conversionProportion", getConversionProportion())
            .append("specificationValues", getSpecificationValues())
            .append("isDel", getIsDel())
            .toString();
    }
}
