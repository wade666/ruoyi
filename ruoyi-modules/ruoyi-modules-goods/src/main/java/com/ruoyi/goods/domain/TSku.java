package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品sku对象 t_sku
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
public class TSku extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 关联商品id */
    @Excel(name = "关联商品id")
    private Long productId;

    /** 销售价 */
    @Excel(name = "销售价")
    private BigDecimal price;

    /** 成本价 */
    @Excel(name = "成本价")
    private BigDecimal cost;

    /** 市场价 */
    @Excel(name = "市场价")
    private BigDecimal marketPrice;

    /** 库存 */
    @Excel(name = "库存")
    private Integer stock;

    /** 已分配库存 */
    @Excel(name = "已分配库存")
    private Integer allocatedStock;

    /** 是否默认 */
    @Excel(name = "是否默认")
    private Integer isDefault;

    /** 规格值[] */
    @Excel(name = "规格值[]")
    private String specificationValues;

    /** 规格图片 */
    @Excel(name = "规格图片")
    private String image;

    /** sku编号全局唯一 */
    @Excel(name = "sku编号全局唯一")
    private String sn;

    /** 重量 */
    @Excel(name = "重量")
    private BigDecimal weight;

    /** 兑换积分 */
    @Excel(name = "兑换积分")
    private Long exchangePoint;

    /** 赠送积分 */
    @Excel(name = "赠送积分")
    private Long rewardPoint;

    /** 是否上架 1是2否 */
    @Excel(name = "是否上架 1是2否")
    private Integer isSale;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setMarketPrice(BigDecimal marketPrice) 
    {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getMarketPrice() 
    {
        return marketPrice;
    }
    public void setStock(Integer stock) 
    {
        this.stock = stock;
    }

    public Integer getStock() 
    {
        return stock;
    }
    public void setAllocatedStock(Integer allocatedStock) 
    {
        this.allocatedStock = allocatedStock;
    }

    public Integer getAllocatedStock() 
    {
        return allocatedStock;
    }
    public void setIsDefault(Integer isDefault) 
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault() 
    {
        return isDefault;
    }
    public void setSpecificationValues(String specificationValues) 
    {
        this.specificationValues = specificationValues;
    }

    public String getSpecificationValues() 
    {
        return specificationValues;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }

    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setExchangePoint(Long exchangePoint) 
    {
        this.exchangePoint = exchangePoint;
    }

    public Long getExchangePoint() 
    {
        return exchangePoint;
    }
    public void setRewardPoint(Long rewardPoint) 
    {
        this.rewardPoint = rewardPoint;
    }

    public Long getRewardPoint() 
    {
        return rewardPoint;
    }
    public void setIsSale(Integer isSale) 
    {
        this.isSale = isSale;
    }

    public Integer getIsSale() 
    {
        return isSale;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("price", getPrice())
            .append("cost", getCost())
            .append("marketPrice", getMarketPrice())
            .append("stock", getStock())
            .append("allocatedStock", getAllocatedStock())
            .append("isDefault", getIsDefault())
            .append("specificationValues", getSpecificationValues())
            .append("image", getImage())
            .append("sn", getSn())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("weight", getWeight())
            .append("exchangePoint", getExchangePoint())
            .append("rewardPoint", getRewardPoint())
            .append("isSale", getIsSale())
            .toString();
    }
}
